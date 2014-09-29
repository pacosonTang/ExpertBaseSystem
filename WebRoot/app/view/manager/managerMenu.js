//管理员菜单
var managerMenu = Ext.create('Ext.tree.Panel', {
	animate : true,
	frame : true,
	rootVisible : false,
	lines : true,
	width : 200,
	height : 700,
	root : {// 设置树形菜单的根
		text : '功能菜单',
		id : '0',
		expanded : true,
		leaf : false,
		children : [ {// 设置树形节点的第一级分支
			text : '我的资料',
			id : 'myInfo',
			leaf : true,
		}, {
			id : 'leaderManage',
			text : '领导管理',
			leaf : true
		}, {
			id : 'serverManage',
			text : '服务人员管理',
			leaf : true
		}, {
			id : 'memberManage',
			text : '会员管理',
			leaf : true
		}, {
			id : 'modifyPass',
			text : '修改账户密码',
			leaf : true
		} ]
	}
});