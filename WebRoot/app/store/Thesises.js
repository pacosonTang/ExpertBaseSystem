Ext.create("Ext.data.Store", {
	model : 'Thesis',
	storeId : 'ThesisStore',
	proxy : {
		type : 'ajax',
		url : 'common/showThesises.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		},
		writer : {
			type : 'json'
		}
	},
	autoLoad : false
});