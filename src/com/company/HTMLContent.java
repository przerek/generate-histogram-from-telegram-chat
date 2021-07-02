package com.company;

public class HTMLContent {
    String colorin = "\"#4f9c43\"";
    String colorout = "\"#ab423a\"";
    String section_a1 = "  var ";
    String section_a2 = " = {\n" +
            "    animationEnabled: true,\n" +
            "    theme: \"light2\", // \"light1\", \"light2\", \"dark1\", \"dark2\"\n" +
            "    title:{\n" +
            "      text: \"";


    String section_a3v1 = "\"},\n" +
            "    axisY: {\n" +
            "      labelFormatter: addSymbols,\n" +
            "title: \"Liczba wiadomości\"\n" +
            "    },\n" +
            "    axisX: {\n interval:";


    String section_a3v2v1 =
            "  \n  },\n" +
                    "    data: [{\n" +
                    "      type: \"column\", //change type to bar, line, area, pie, etc\n" +
                    "      color: ";
    String section_a3v2v2 = ",\n" +
            "      dataPoints: [";


    String section_a4 = "      ]\n" +
            "    }]\n" +
            "  };\n";

    String section_a = "<!DOCTYPE HTML>\n" +
            "<html>\n" +
            "<head>\n" +
            "<meta charset=\"UTF-8\">" +
            "" +
            "<script>\n" +
            "window.onload = function () {\n" +
            "  var charts = [];\n" +
            "  var axisX = {\n" +
            "    labelFormatter: function(){ return \"\";},\n" +
            "    tickLength: 0,\n" +
            "    lineThickness: 0,\n" +
            "  }, \n" +
            "  axisY = {\n" +
            "    labelFormatter: function(){ return \"\";},\n" +
            "    tickLength: 0,\n" +
            "    gridThickness: 0,\n" +
            "  };\n" +
            "  ";

    String section_c = "\n" +
            "  for( var i = 0; i < charts.length; i++){\n" +
            "    charts[i].render();\n" +
            "  }\n" +
            "\n" +
            "  function syncTooltip(charts) {\n" +
            "    \n" +
            "    if(!this.onToolTipUpdated){\n" +
            "      this.onToolTipUpdated = function(e) {\n" +
            "        for (var j = 0; j < charts.length; j++) {\n" +
            "          if (charts[j] != e.chart)\n" +
            "            charts[j].toolTip.showAtX(e.entries[0].xValue);\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "\n" +
            "    if(!this.onToolTipHidden){\n" +
            "      this.onToolTipHidden = function(e) {\n" +
            "        for( var j = 0; j < charts.length; j++){\n" +
            "          if(charts[j] != e.chart)\n" +
            "            charts[j].toolTip.hide();\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "    \n" +
            "    for(var i = 0; i < charts.length; i++) { \n" +
            "        if(!charts[i].options.toolTip)\n" +
            "          charts[i].options.toolTip = {};\n" +
            "\n" +
            "        charts[i].options.toolTip.updated = this.onToolTipUpdated;\n" +
            "        charts[i].options.toolTip.hidden = this.onToolTipHidden;\n" +
            "    }  \n" +
            "  }\n" +
            "\n" +
            "  function addSymbols(e){\n" +
            "      var suffixes = [\"\", \"K\", \"M\", \"B\"];\n" +
            "\n" +
            "      var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);\n" +
            "      if(order > suffixes.length - 1)\n" +
            "          order = suffixes.length - 1;\n" +
            "\n" +
            "      var suffix = suffixes[order];\n" +
            "      return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;\n" +
            "  }\n" +
            "}\n" +
            "</script>\n" +
            "<style>\n" +
            "  .row:after {\n" +
            "    content: \"\";\n" +
            "    display: table;\n" +
            "    clear: both;\n" +
            "  }\n" +
            "  .col {\n" +
            "    float: left;\n" +
            "    width: 33.33%;\n" +
            "    height: 100px;\n" +
            "  }\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n";

    String section_e = "<script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n" +
            "</body>\n" +
            "</html>";

}
