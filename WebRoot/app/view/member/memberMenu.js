//管理员菜单
var memberMenu = Ext.create('Ext.tree.Panel', {
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
			id : 'awardManage',
			text : '奖励管理',
			leaf : true
		}, {
			id : 'thesisManage',
			text : '论文管理',
			leaf : true
		}, {
			id : 'patentManage',
			text : '专利管理',
			leaf : true
		}, {
			id : 'projectManage',
			text : '项目管理',
			leaf : true
		}, {
			id : 'modifyCount',
			text : '修改密码',
			leaf : true
		} ]
	}
});