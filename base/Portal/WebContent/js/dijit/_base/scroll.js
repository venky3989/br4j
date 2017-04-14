/*
	Copyright (c) 2004-2009, The Dojo Foundation All Rights Reserved.
	Available via Academic Free License >= 2.1 OR the modified BSD license.
	see: http://dojotoolkit.org/license for details
*/


if(!dojo._hasResource["dijit._base.scroll"]){
dojo._hasResource["dijit._base.scroll"]=true;
dojo.provide("dijit._base.scroll");
dijit.scrollIntoView=function(_1,_2){
try{
_1=dojo.byId(_1);
var _3=_1.ownerDocument||dojo.doc,_4=_3.body||dojo.body(),_5=_3.documentElement||_4.parentNode,_6=dojo.isIE,_7=dojo.isWebKit;
if((!(dojo.isMoz||_6||_7||dojo.isOpera)||_1==_4||_1==_5)&&(typeof _1.scrollIntoView!="undefined")){
_1.scrollIntoView(false);
return;
}
var _8=_3.compatMode=="BackCompat",_9=(_6>=9&&_1.ownerDocument.parentWindow.frameElement)?((_5.clientHeight>0&&_5.clientWidth>0&&(_4.clientHeight==0||_4.clientWidth==0||_4.clientHeight>_5.clientHeight||_4.clientWidth>_5.clientWidth))?_5:_4):(_8?_4:_5),_a=_7?_4:_9,_b=_9.clientWidth,_c=_9.clientHeight,_d=!dojo._isBodyLtr(),_e=_2||dojo.position(_1),el=_1.parentNode,_f=function(el){
return ((_6<=6||(_6&&_8))?false:(dojo.style(el,"position").toLowerCase()=="fixed"));
};
if(_f(_1)){
return;
}
while(el){
if(el==_4){
el=_a;
}
var _10=dojo.position(el),_11=_f(el);
if(el==_a){
_10.w=_b;
_10.h=_c;
if(_a==_5&&_6&&_d){
_10.x+=_a.offsetWidth-_10.w;
}
if(_10.x<0||!_6){
_10.x=0;
}
if(_10.y<0||!_6){
_10.y=0;
}
}else{
var pb=dojo._getPadBorderExtents(el);
_10.w-=pb.w;
_10.h-=pb.h;
_10.x+=pb.l;
_10.y+=pb.t;
var _12=el.clientWidth,_13=_10.w-_12;
if(_12>0&&_13>0){
_10.w=_12;
_10.x+=(_d&&(_6||el.clientLeft>pb.l))?_13:0;
}
_12=el.clientHeight;
_13=_10.h-_12;
if(_12>0&&_13>0){
_10.h=_12;
}
}
if(_11){
if(_10.y<0){
_10.h+=_10.y;
_10.y=0;
}
if(_10.x<0){
_10.w+=_10.x;
_10.x=0;
}
if(_10.y+_10.h>_c){
_10.h=_c-_10.y;
}
if(_10.x+_10.w>_b){
_10.w=_b-_10.x;
}
}
var l=_e.x-_10.x,t=_e.y-Math.max(_10.y,0),r=l+_e.w-_10.w,bot=t+_e.h-_10.h;
if(r*l>0){
var s=Math[l<0?"max":"min"](l,r);
if(_d&&((_6==8&&!_8)||_6>=9)){
s=-s;
}
_e.x+=el.scrollLeft;
el.scrollLeft+=s;
_e.x-=el.scrollLeft;
}
if(bot*t>0){
_e.y+=el.scrollTop;
el.scrollTop+=Math[t<0?"max":"min"](t,bot);
_e.y-=el.scrollTop;
}
el=(el!=_a)&&!_11&&el.parentNode;
}
}
catch(error){
console.error("scrollIntoView: "+error);
_1.scrollIntoView(false);
}
};
}
