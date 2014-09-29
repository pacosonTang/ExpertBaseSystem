Ext.define("Award", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id',type:'int',sortable:true},
		{name : 'name',type:'string',sortable:true},
		{name : 'fruitName',type:'string',sortable:true},
		{name : 'awardTime',type:'string',sortable:true},
		{name : 'rank',type:'int',sortable:true}
	]
});