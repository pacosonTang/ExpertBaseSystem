Ext.create("Ext.data.Store", {
	model : 'Leader',
	storeId : 'LeaderStore',
	proxy : {
		type : 'ajax',
		url : 'manager/showLeaders.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		}
	}
});