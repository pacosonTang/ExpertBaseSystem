Ext.create("Ext.data.Store", {
	model : 'Server',
	storeId : 'ServerStore',
	proxy : {
		type : 'ajax',
		url : 'manager/showServers.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		}
	}
});