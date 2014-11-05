Ext.onReady(function(){  
        new Mic.GridPanel({  
            title : 'test',  
            width : 500,  
            height : 410,  
            dataUrl : 'extjs_test!getList',  
            dwrStore : false,  
            colMapping : ['id','name'],  
            headers : [  
                { header: "Id", width: 60, dataIndex:'id'},  
                { header: "名称", width: 150, dataIndex:'name'}  
            ]  
        }).render(Ext.getBody());  
    });  