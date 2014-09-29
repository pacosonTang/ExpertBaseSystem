Ext.create("Ext.data.Store", {
	model : 'Major',
	storeId : 'ThirdMajorStore',
	proxy : {
		type : 'ajax',
		url : 'common/showSubjects.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		},
		actionMethod : {read : 'POST'},
		autoLoad : false
	}
});