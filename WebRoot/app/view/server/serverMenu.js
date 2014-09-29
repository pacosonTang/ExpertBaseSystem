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
			id : 'memberSearch',
			text : '会员查询',
			leaf : true
		}, {
			id : 'modifyPass',
			text : '修改密码',
			leaf : true
		} ]
	}
});