Ext.create("Ext.data.Store", {
	model : 'User',
	storeId : 'UserStore',
	proxy : {
		type : 'ajax',
		url : 'manager/showMembers.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		},
		wirter : {
			type : 'json'
		}
	}
});