//User类
Ext.define("Server", {
	extend : 'Ext.data.Model',
	fields : [
  		{name:'id', type:'int', sortable:true},
  		{name:'realname', type:'string', sortable:true},
  		{name:'username', type:'string', sortable:true},
  		{name:'password', type:'string', sortable:true},
  		{name:'workUnit', type:'String', sortable:true},
  		{name:'telephone', type:'string', sortable:true},
  		{name:'officePhone', type:'string', sortable:true},
  		{name:'postcode', type:'string', sortable:true},
  		{name:'email', type:'string', sortable:true},
  		{name:'address', type:'string', sortable:true},
  		{name:'avatar', type:'string', sortable:true},
  		{name:'sex', type:'string', sortable:true},
  		{name:'duty', type:'string', sortable:true}
  	]
});