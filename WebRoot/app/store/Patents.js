Ext.create("Ext.data.Store", {
	model : 'Patent',
	storeId : 'PatentStore',
	proxy : {
		type : 'ajax',
		url : 'manager/showPatents.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		}
	},
	autoLoad : false
});