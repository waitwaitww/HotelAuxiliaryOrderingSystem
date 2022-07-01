"use strict";(self["webpackChunkhotel"]=self["webpackChunkhotel"]||[]).push([[72],{2072:function(e,t,a){a.r(t),a.d(t,{default:function(){return v}});var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-menu",{staticClass:"el-menu-homepage",staticStyle:{"text-align":"left"},attrs:{mode:"horizontal","background-color":"#1F4B62","text-color":"#fff","active-text-color":"#ffd04b"}},[a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"点击回到主页",placement:"bottom"}},[a("el-menu-item",{staticStyle:{width:"180px",float:"left"},attrs:{index:"10"},on:{click:function(t){return e.backtoHomepage()}}},[e._v(" 回到主页 ")])],1)],1),a("el-container",{staticStyle:{height:"calc(100vh - 80px)",border:"1px solid #eee"}},[a("el-header",{staticStyle:{"background-color":"rgb(238, 241, 246)"},attrs:{width:"200px"}},[a("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":e.activeIndex,mode:"horizontal"},on:{select:e.handleSelect}},[a("el-submenu",{attrs:{index:"1"},scopedSlots:e._u([{key:"title",fn:function(){return[a("i",{staticClass:"el-icon-message"}),e._v("何")]},proxy:!0}])},[a("el-menu-item-group",[a("router-link",{attrs:{to:"/personinfo"}},[a("el-menu-item",{attrs:{index:"1-1"}},[e._v("用户信息")])],1),a("router-link",{attrs:{to:"/changeinfo"}},[a("el-menu-item",{attrs:{index:"1-2"}},[e._v("修改信息")])],1)],1)],1),a("el-submenu",{attrs:{index:"10"},scopedSlots:e._u([{key:"title",fn:function(){return[e._v(" 我的订单 ")]},proxy:!0}])},[a("el-menu-item",{attrs:{index:"20"}},[a("router-link",{attrs:{to:"/ormanage"}},[e._v(" 全部订单 ")])],1),a("el-menu-item",{attrs:{index:"30"}},[a("router-link",{attrs:{to:"/orderwaitpay"}},[e._v(" 待付款订单 ")])],1),a("el-menu-item",{attrs:{index:"40"}},[a("router-link",{attrs:{to:"/orderwillcancel"}},[e._v(" 已付款订单 ")])],1),a("el-menu-item",{attrs:{index:"50"}},[a("router-link",{attrs:{to:"/ordercheckedin"}},[e._v(" 已入住订单 ")])],1),a("el-menu-item",{attrs:{index:"60"}},[a("router-link",{attrs:{to:"/ordercanceled"}},[e._v(" 已退房订单 ")])],1)],1),a("router-view")],1),a("router-view")],1),a("el-container",[a("el-main",{staticStyle:{position:"relative",width:"70%",left:"15%"}},[a("el-table",{attrs:{data:e.tableData,"empty-text":"无此类订单"}},[a("el-table-column",{attrs:{prop:"o_id",label:"订单号",width:"140"}}),a("el-table-column",{attrs:{prop:"u_id",label:"用户id",width:"140"}}),a("el-table-column",{attrs:{prop:"hname",label:"酒店id",width:"140"}}),a("el-table-column",{attrs:{prop:"rtname",label:"房型id",width:"140"}}),a("el-table-column",{attrs:{prop:"Create_time",label:"创建日期",width:"200"}}),a("el-table-column",{attrs:{prop:"state",label:"订单状态",width:"80"}}),a("el-table-column",{attrs:{prop:"option",label:"操作",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"warning",size:"mini"},on:{click:function(a){return e.payorder(t.row)}}},[e._v("立即支付")]),a("el-button",{attrs:{type:"info",size:"mini"},on:{click:function(a){return e.cancel(t.row)}}},[e._v("取消")])]}}])})],1)],1)],1)],1)],1)},n=[],i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"desc",style:{margin:e.margin}},[e.title?a("h1",{staticClass:"desc-title",domProps:{innerHTML:e._s(e.title)}}):e._e(),a("el-row",{ref:"elRow",staticClass:"desc-row"},[e._t("default")],2)],1)},l=[],o={name:"EDesc",provide(){return{labelWidth:this.labelWidth,column:this.column,size:this.size}},props:{title:{type:String,default:""},margin:{type:String,default:"0"},labelWidth:{type:String,default:"120px"},column:{type:[Number,String],default:3},size:{type:String,default:""}},data(){return{observe:new MutationObserver(this.computedSpan)}},mounted(){this.$nextTick((()=>{this.computedSpan(),this.observe.observe(this.$refs.elRow.$el,{childList:!0})}))},methods:{computedSpan(){const e=this.$slots.default,t=[];e.forEach((e=>{e.componentOptions&&"e-desc-item"===e.componentOptions.tag&&t.push(e.componentInstance)}));let a=this.column;const s=t.length;t.forEach(((e,n)=>{const i=a<=(e.span||1),l=n<s-1&&t[n+1].span>=a,o=n===s-1;i||l||o?(e.selfSpan=a,a=this.column):a-=e.span||1}))}},beforeUnmount(){this.observer.disconnect()}},r=o,c=a(1001),u=(0,c.Z)(r,i,l,!1,null,"94d2a4da",null),d=(u.exports,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-col",{staticClass:"desc-item",attrs:{span:e.computedSpan}},[a("div",{staticClass:"desc-item-content",class:e.size},[a("label",{staticClass:"desc-item-label",style:{width:e.labelWidth},domProps:{innerHTML:e._s(e.label)}}),e.$slots?a("div",{staticClass:"desc-item-value"},[e._t("default")],2):e._e()])])}),p=[],m={name:"EDescItem",inject:["labelWidth","column","size"],props:{span:{type:[Number,String],required:!1,default:0},label:{type:String,required:!1,default:""}},data(){return{selfSpan:0}},computed:{computedSpan(){return this.selfSpan?24/this.column*this.selfSpan:this.span?24/this.column*this.span:24/this.column}}},h=m,f=(0,c.Z)(h,d,p,!1,null,"2a659667",null),_=(f.exports,{name:"orderwaitpay",data(){return{tableData:[{o_id:"210615001",u_id:"2019141460096",h_id:"103872",hname:"成都世纪城天堂洲际大饭店",rtname:"大床房",Create_time:"2021-06-15 14:04:12",checkin_time:"2021-06-25 14:04:14",checkout_time:"2021-06-30 14:04:17",state:"待支付",total_price:"3000",rating:"5",review:"舒适，但床在摇晃",pname1:"何翔龙",pname2:"凤姐",p1_tel:"12124404047",p2_tel:"12147752774"},{o_id:"210615001",u_id:"2019141460096",h_id:"103872",hname:"成都世纪城天堂洲际大饭店",rtname:"大床房",Create_time:"2021-06-15 14:04:12",checkin_time:"2021-06-25 14:04:14",checkout_time:"2021-06-30 14:04:17",state:"待支付",total_price:"3000",rating:"5",review:"舒适，但床在摇晃",pname1:"何翔龙",pname2:"凤姐",p1_tel:"12124404047",p2_tel:"12147752774"}]}},methods:{backtoHomepage(){this.$router.push("/homepage")},getnotpaiedorderinfo(){const e=this;this.$axios({url:"/api/orderList/ListByState",method:"POST",params:{pageNo:1,pageSize:10,state:"待支付"}}).then((t=>{t.data.data&&(e.tableData=t.data.data)})).catch((e=>{console.log(e,"err")}))},openSuccess(){this.$message({showClose:!0,message:"支付成功",type:"success"})},openFail(){this.$message({showClose:!0,message:"支付失败",type:"error"})},opencancelSuccess(){this.$message({showClose:!0,message:"订单待取消，请等待审核",type:"success"})},opencancelFail(){this.$message({showClose:!0,message:"订单取消失败",type:"error"})},payorder(e){const t=this;this.$axios({url:"/api/orderList/UpdateState",method:"POST",params:{o_id:e.o_id,newstate:"已付款"}}).then((e=>{t.openSuccess()})).catch((e=>{t.openFail(),console.log(e,"err")})),this.$router.go(0)},cancel(e){const t=this;this.$axios({url:"/api/orderList/UpdateState",method:"POST",params:{o_id:e.o_id,newstate:"待取消"}}).then((e=>{t.opencancelSuccess()})).catch((e=>{t.opencancelFail(),console.log(e,"err")})),this.$router.go(0)}},created(){this.getnotpaiedorderinfo()}}),b=_,g=(0,c.Z)(b,s,n,!1,null,"4345a4a6",null),v=g.exports}}]);
//# sourceMappingURL=72.bda65828.js.map