Ext.create("Ext.data.Store", {
	model : 'Project',
	storeId : 'ProjectStore',
	proxy : {
		type : 'ajax',
		url : 'common/showProjects.action',
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