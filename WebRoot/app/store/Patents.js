Ext.create("Ext.data.Store", {
	model : 'Patent',
	storeId : 'PatentStore',
	proxy : {
		type : 'ajax',
		url : 'common/showPatents.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		}
	},
	autoLoad : false
});