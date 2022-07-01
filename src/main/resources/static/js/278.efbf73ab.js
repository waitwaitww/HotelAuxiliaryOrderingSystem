"use strict";(self["webpackChunkhotel"]=self["webpackChunkhotel"]||[]).push([[278],{278:function(e,t,a){a.r(t),a.d(t,{default:function(){return c}});var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-menu",{staticClass:"el-menu-homepage",staticStyle:{"text-align":"left"},attrs:{mode:"horizontal","background-color":"#1F4B62","text-color":"#fff","active-text-color":"#ffd04b"}},[a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"点击回到主页",placement:"bottom"}},[a("el-menu-item",{staticStyle:{width:"180px",float:"left"},attrs:{index:"10"},on:{click:function(t){return e.backtoHomepage()}}},[e._v(" 回到主页 ")])],1)],1),a("el-container",{staticStyle:{height:"calc(100vh - 80px)",border:"1px solid #eee"}},[a("el-header",{staticStyle:{"background-color":"rgb(238, 241, 246)"},attrs:{width:"200px"}},[a("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":e.activeIndex,mode:"horizontal"},on:{select:e.handleSelect}},[a("el-submenu",{attrs:{index:"1"},scopedSlots:e._u([{key:"title",fn:function(){return[a("i",{staticClass:"el-icon-message"}),e._v("何")]},proxy:!0}])},[a("el-menu-item-group",[a("router-link",{attrs:{to:"/personinfo"}},[a("el-menu-item",{attrs:{index:"1-1"}},[e._v("用户信息")])],1),a("router-link",{attrs:{to:"/changeinfo"}},[a("el-menu-item",{attrs:{index:"1-2"}},[e._v("修改信息")])],1)],1)],1),a("el-submenu",{attrs:{index:"10"},scopedSlots:e._u([{key:"title",fn:function(){return[e._v(" 我的订单 ")]},proxy:!0}])},[a("el-menu-item",{attrs:{index:"20"}},[a("router-link",{attrs:{to:"/ormanage"}},[e._v(" 全部订单 ")])],1),a("el-menu-item",{attrs:{index:"30"}},[a("router-link",{attrs:{to:"/orderwaitpay"}},[e._v(" 待付款订单 ")])],1),a("el-menu-item",{attrs:{index:"40"}},[a("router-link",{attrs:{to:"/orderwillcancel"}},[e._v(" 已付款订单 ")])],1),a("el-menu-item",{attrs:{index:"50"}},[a("router-link",{attrs:{to:"/ordercheckedin"}},[e._v(" 已入住订单 ")])],1),a("el-menu-item",{attrs:{index:"60"}},[a("router-link",{attrs:{to:"/ordercanceled"}},[e._v(" 已退房订单 ")])],1)],1),a("router-view")],1),a("router-view")],1),a("el-container",[a("el-main",{staticStyle:{position:"relative",width:"70%",left:"15%"}},[a("el-table",{attrs:{data:e.tableData,"empty-text":"无已入住订单"}},[a("el-table-column",{attrs:{prop:"o_id",label:"订单号",width:"140"}}),a("el-table-column",{attrs:{prop:"u_id",label:"用户id",width:"140"}}),a("el-table-column",{attrs:{prop:"h_id",label:"酒店id",width:"140"}}),a("el-table-column",{attrs:{prop:"rtname",label:"房型id",width:"140"}}),a("el-table-column",{attrs:{prop:"Create_time",label:"创建日期",width:"200"}}),a("el-table-column",{attrs:{prop:"state",label:"订单状态",width:"80"}}),a("el-table-column",{attrs:{prop:"comment",label:"评论"}},[a("el-button",{attrs:{type:"text",icon:"el-icon-edit",circle:""},on:{click:function(t){e.dialogVisible=!0}}})],1)],1)],1)],1)],1),a("el-dialog",{attrs:{title:"评论",width:"30%","before-close":e.handleClose},model:{value:e.dialogVisible,callback:function(t){e.dialogVisible=t},expression:"dialogVisible"}},[a("input",{staticStyle:{width:"100%",height:"200px"}}),a("span",{staticClass:"dialog-footer"},[a("el-button",{on:{click:e.handleClose}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.getreview}},[e._v("确 定")])],1)])],1)},i=[],o={name:"ordercheckedin",data(){return{tableData:[{o_id:"210615001",u_id:"2019141460096",h_id:"103872",hname:"成都世纪城天堂洲际大饭店",rtname:"大床房",Create_time:"2021-06-15 14:04:12",checkin_time:"2021-06-25 14:04:14",checkout_time:"2021-06-30 14:04:17",state:"已入住",total_price:"3000",rating:"5",review:"舒适，但床在摇晃",pname1:"何翔龙",pname2:"凤姐",p1_tel:"12124404047",p2_tel:"12147752774"},{o_id:"210615001",u_id:"2019141460096",h_id:"103872",hname:"成都世纪城天堂洲际大饭店",rtname:"大床房",Create_time:"2021-06-15 14:04:12",checkin_time:"2021-06-25 14:04:14",checkout_time:"2021-06-30 14:04:17",state:"已入住",total_price:"3000",rating:"5",review:"舒适，但床在摇晃",pname1:"何翔龙",pname2:"凤姐",p1_tel:"12124404047",p2_tel:"12147752774"}]}},methods:{backtoHomepage(){this.$router.push("/homepage")},handleClose(e){this.$confirm("确认关闭？").then((t=>{this.dialogVisible=!1,e()})).catch((e=>{}))},ordercheckedin(){const e=this;this.$axios({url:"/api/orderList/ListByState",method:"POST",params:{pageNo:1,pageSize:10,state:"已入住"}}).then((t=>{t.data.data&&(e.tableData=t.data.data)})).catch((e=>{console.log(e,"err")}))},getreview(){this.dialogVisible=!1,console.log("获取评论返回后端")}},created(){this.ordercheckedin()}},r=o,n=a(1001),s=(0,n.Z)(r,l,i,!1,null,"780b838c",null),c=s.exports}}]);
//# sourceMappingURL=278.efbf73ab.js.map