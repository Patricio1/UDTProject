'use strict';

(function($){

  $(function() {

    var datascource = {
      'id': '1',
      'name': 'Patricio Landa',
      'title': 'Administrador',
      'children': [
        { 'id': '2', 'name': 'Jesus Adrian Landa Landa', 'title': 'Contador' },
        { 'id': '3', 'name': 'Maria Ermelinda Jacome Aldaz', 'title': 'Recaudador'},          
            { 'id': '4', 'name': 'Carlos Pico', 'title': 'Auxiliar de Administrador de Recursos Informáticos' },
            { 'id': '5', 'name': 'Jhonny Llerera', 'title': 'Administrador de Recursos Informáticos'}                                                            
      ]
    };

    var oc = $('#chart-container').orgchart({
      'data' : datascource,
      'depth': 2,
      'nodeContent': 'title',     
      'nodeID': 'id',      
      'createNode': function($node, data) {
        var secondMenuIcon = $('<i>', {
          'class': 'fa fa-info-circle second-menu-icon',
          click: function() {
            $(this).siblings('.second-menu').toggle();
          }
        });
        var secondMenu = '<div class="second-menu"><img class="avatar" src="img/avatar/' + data.id + '.jpg"></div>';
        $node.append(secondMenuIcon).append(secondMenu);
      }
    });

  });

})(jQuery);