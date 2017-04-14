/**
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to you under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
/**
 * Licensed under the Artistic License; you may not use this file
 * except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://displaytag.sourceforge.net/license.html
 *
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED
 * WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 */
package org.displaytag.decorator;

import javax.servlet.jsp.PageContext;

import org.displaytag.exception.ObjectLookupException;
import org.displaytag.model.TableModel;
import org.displaytag.render.TableWriterTemplate;
import org.displaytag.util.LookupUtil;
import org.displaytag.util.TagConstants;


/**
 * @author epesh
 * @author Fabrizio Giustina
 * @version $Revision: 971 $ ($Author: fgiust $)
 */
public abstract class TableDecorator extends Decorator
{

    /**
     * object representing the current row.
     */
    private Object currentRowObject;

    /**
     * index in displayed list.
     */
    private int viewIndex = -1;

    /**
     * index in original list.
     */
    private int listIndex = -1;

    /**
     * The associated table model.
     */
    protected TableModel tableModel;

    /**
     * Return the index in the displayed list.
     * @return int index in the displayed list
     */
    public final int getViewIndex()
    {
        return this.viewIndex;
    }

    /**
     * Return the index in the full list (view index + offset). Note that the index returned if from the <strong>sorted</strong>
     * list, and not from the original one.
     * @return int index in the full list
     */
    public final int getListIndex()
    {
        return this.listIndex;
    }

    /**
     * Get the object representing the current row.
     * @return Object
     */
    public final Object getCurrentRowObject()
    {
        return this.currentRowObject;
    }

    /**
     * Initialize the TableTecorator instance.
     * @param context PageContext
     * @param decorated decorated object (usually a list)
     * @param tableModel the tableModel
     */
    public void init(PageContext context, Object decorated, TableModel tableModel)
    {
        this.tableModel = tableModel;
        this.init(context, decorated);
    }

    /**
     * Initialize the current row. Note this method is also called when sorting a table using a property supplied by the
     * table decorator, so the method could be called multiple times during rendering. When used to initialize sorting
     * the method is always called with 0, 0 as currentViewIndex and currentListIndex.
     * @param rowObject object representing the current row
     * @param currentViewIndex int index in the displayed list
     * @param currentListIndex int index in the original list
     */
    public final void initRow(Object rowObject, int currentViewIndex, int currentListIndex)
    {
        this.currentRowObject = rowObject;
        this.viewIndex = currentViewIndex;
        this.listIndex = currentListIndex;
    }

    /**
     * Called at the beginning of a row. Can be subclassed to provide specific data at the beginning of a row
     * @return null in the default implementation
     */
    public String startRow()
    {
        return null;
    }

    /**
     * Called at the end of a row. Can be subclassed to provide specific data at the end of a row
     * @return null in the default implementation
     */
    public String finishRow()
    {
        return null;
    }

    /**
     * Called at the end of evaluation. Can be subclassed to eventully clean up data. Always remember to also call
     * super.finish()!
     */
    public void finish()
    {
        this.currentRowObject = null;
        super.finish();
    }

    /**
     * Call back to add an additional row class to the current row.
     * @return CSS class attribute value for the current row
     * @since 1.1
     */
    public String addRowClass()
    {
        return null;
    }

    /**
     * Call back to allow setting an "id" attribute on a row.
     * @return HTML id attribute value for the current row
     * @since 1.1
     */
    public String addRowId()
    {
        return null;
    }

    /**
     * Indicates that we are begining a new group.
     * @param value of the current cell
     * @param group number of the current column
     */
    public void startOfGroup(String value, int group)
    {
    }

    /**
     * Called at the end of a group. Can be subclassed to provide specific data at the end of a row.
     * @param value of the current cell
     * @param groupThatHasEnded number of the current column
     */
    public void endOfGroup(String value, int groupThatHasEnded)
    {
    }

    /**
     * What value should I display in this cell? The default value for grouped columns is to not display any value if
     * the cellValue has not changed on an interior iteration. Only invoked for columns that are grouped.
     * @param cellValue
     * @param groupingStatus
     * @return the value to display
     */
    public String displayGroupedValue(String cellValue, short groupingStatus)
    {
        if (groupingStatus == TableWriterTemplate.GROUP_END || groupingStatus == TableWriterTemplate.GROUP_NO_CHANGE)
        {
            return TagConstants.EMPTY_STRING;
        }
        else
        {
            return cellValue;
        }
    }

    public boolean isLastRow()
    {
        return getListIndex() == this.tableModel.getRowListPage().size() - 1;
    }

    /**
     * Shortcut for evaluating properties in the current row object. Can be useful for implementing anonymous decorators
     * in jsp pages without having to know/import the decorated object Class.
     * @param propertyName property to lookup in current row object. Can also be a nested or indexed property.
     * @since 1.1
     */
    protected Object evaluate(String propertyName)
    {
        try
        {
            return LookupUtil.getBeanProperty(getCurrentRowObject(), propertyName);
        }
        catch (ObjectLookupException e)
        {
            return null;
        }
    }

}