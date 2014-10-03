Ext.create("Ext.data.Store", {
	model : 'Award',
	storeId : 'AwardStore',
	proxy : {
		type : 'ajax',
		url : 'common/showAwards.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		}
	},
	autoLoad : false
});