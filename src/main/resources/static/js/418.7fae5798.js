"use strict";(self["webpackChunkhotel"]=self["webpackChunkhotel"]||[]).push([[418],{2418:function(t,e,i){i.r(e),i.d(e,{default:function(){return c}});var l=function(){var t=this,e=t.$createElement,l=t._self._c||e;return l("el-container",[l("el-header",{staticStyle:{position:"relative",display:"flex","justify-content":"space-between"}},[l("img",{staticStyle:{width:"20%",position:"relative",left:"10%"},attrs:{src:i(3182)}}),l("div",[l("i",{staticClass:"el-icon-user-solid",staticStyle:{"font-size":"30px",position:"relative",right:"70%"}},[l("el-link",{staticStyle:{"font-size":"20px",color:"rgb(0,0,0)"},attrs:{underline:!1,type:"primary"}},[t._v("我的用户")])],1),l("i",{staticClass:"el-icon-s-order",staticStyle:{"font-size":"30px",position:"relative",right:"40%"}},[l("el-link",{staticStyle:{"font-size":"20px",color:"rgb(0,0,0)"},attrs:{underline:!1,type:"primary"},on:{click:t.myorm}},[t._v("我的订单")])],1)])]),l("el-main",{staticStyle:{position:"absolute",height:"100%",top:"15%",width:"100%"}},[l("el-container",{staticStyle:{height:"100%"}},[l("el-header",{staticStyle:{width:"100%"}},[l("div",{staticClass:"demo-input-size",staticStyle:{width:"100%"}},[l("el-input",{staticStyle:{width:"15%"},attrs:{placeholder:"酒店名称"},model:{value:t.input1,callback:function(e){t.input1=e},expression:"input1"}}),l("el-date-picker",{staticStyle:{width:"25%"},attrs:{type:"daterange","start-placeholder":"入住时间","end-placeholder":"退房时间","default-time":["00:00:00","23:59:59"]}}),l("el-select",{staticStyle:{width:"15%"},attrs:{placeholder:"星级"}},t._l(t.options,(function(e){return l("el-option",{key:e.value,attrs:{label:e.label,value:e.value}},[l("span",{staticStyle:{float:"left"}},[t._v(t._s(e.label))]),l("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[t._v(t._s(e.value))])])})),1),l("el-input",{staticStyle:{width:"15%"},attrs:{placeholder:"关键词(选填)"},model:{value:t.input4,callback:function(e){t.input4=e},expression:"input4"}}),l("el-button",{staticStyle:{color:"white","background-color":"rgb(132,146,166)"},attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.searchresult}},[l("span",[t._v("搜索")])])],1)]),l("el-main",{staticStyle:{height:"80%"}},[l("el-container",{staticStyle:{height:"862px",width:"100%"}},[t._l(t.Arr,(function(e){return l("el-header",{key:e.id,staticStyle:{"box-shadow":"0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)",position:"relative",height:"45%",top:"5%",width:"80%",display:"flex",left:"10%"}},[l("el-aside",{staticStyle:{height:"100%",width:"60%",display:"flex",position:"relative"}},[l("img",{staticClass:"roomphoto1",attrs:{src:e.imageurl2}}),l("img",{staticClass:"roomphoto2",attrs:{src:e.imageurl3}}),l("span",{staticClass:"hotelname"},[t._v(t._s(e.hotelname))]),l("span",{staticClass:"hoteladdress"},[t._v(t._s(e.hoteladdress))])]),l("el-main",{staticStyle:{height:"100%",display:"flex",position:"relative"}},[l("el-button",{staticClass:"roomselect",attrs:{type:"primary",round:""},on:{click:t.create}},[t._v("选择房间")])],1)],1)})),l("el-main",{staticStyle:{position:"relative",top:"5%",display:"inline"}},[l("div",{staticStyle:{position:"relative",top:"5%",height:"20%",width:"80%",left:"10%","box-shadow":"0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)"}},[l("span",{staticStyle:{"font-size":"larger"}},[t._v("房间列表")])]),l("ul",{staticStyle:{"min-height":"200px",position:"relative","list-style-type":"none",width:"77.7%",left:"10%",top:"5%","box-shadow":"0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)"}},[l("div",{staticClass:"roomviewlist-item"},[l("el-aside",{staticStyle:{display:"inline"},attrs:{width:"200px"}},[l("img",{staticClass:"roomphoto3",attrs:{src:i(4409)}}),l("span",{staticClass:"roomtypeview"},[t._v("房间介绍")])]),l("el-main",[l("el-button",{staticClass:"order",attrs:{type:"warning",round:""}},[t._v("预定房间")])],1)],1)])])],2)],1)],1)],1)],1)},s=[],a={name:"DetailPage",data(){return{getresult:"",Arr:[]}},methods:{create:function(){this.getresult=this.$route.query.getresult;let t=this.getresult;console.log(this.$route.query.getresult),console.log(this.getresult);let e=[{id:1,hoteltitle:t.hname,hoteladdress:t.haddress.addressLine,hotelrating:t.starRating,hotelprice:t.priceAvg,imageurl2:t.hphotos[2].url,imageurl3:t.hphotos[3],imageurl4:t.hphotos[4],hotelid:t.hid}];var i=JSON.parse(JSON.stringify(e));this.Arr=i,console.log(this.Arr)}}},o=a,r=i(1001),n=(0,r.Z)(o,l,s,!1,null,"b6c74e16",null),c=n.exports},3182:function(t,e,i){t.exports=i.p+"img/logo.f1454053.png"}}]);
//# sourceMappingURL=418.7fae5798.js.map