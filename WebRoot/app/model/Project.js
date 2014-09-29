Ext.define("Project", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id',type:'int',sortable:true},
		{name : 'name',type:'string',sortable:true},
		{name : 'projectTime',type:'string',sortable:true},
		{name : 'selfFunc',type:'string',sortable:true},
		{name : 'delegationUnit',type:'string',sortable:true},
		{name : 'projectLevel',type:'int',sortable:true},
		{name : 'completeStatus',type:'int',sortable:true},
		{name : 'allocation',type:'int',sortable:true},
		{name : 'selffinance',type:'int',sortable:true}
	]
});