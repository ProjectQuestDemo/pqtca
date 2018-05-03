(function () {
    /*
        Uses Google Chart API
    */

    // Loads api for use
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
    function drawChart() {

        //Fetch by Ethnicity
        fetch('/graphEthnicity').then((response) => response.json()).then((jsonData) => {
            var arr = [['Ethnicity', 'Number Of Applicants']];
            for(const key of Object.keys(jsonData)) {
                arr.push([key, jsonData[key]]);
            }

            var data = google.visualization.arrayToDataTable(arr);

            // Optional; add a title and set the width and height of the chart
            var options = {'title': 'Demographics', 'width': 500, 'height': 250};

            // Display the chart inside the <div> element with id="piechart"
            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
        });

        //====================================================================================//

        //Fetching by city put on application
        fetch('/graphCity').then((response) => response.json()).then((jsonData) => {
            var arr = [['City', ' Cities']];
            for(const key of Object.keys(jsonData)) {
                arr.push([key, jsonData[key]]);
            }

            var data = google.visualization.arrayToDataTable(arr);

            // Optional; add a title and set the width and height of the chart
            var options = {'title': 'Demographics', 'width': 500, 'height': 250};

            // Display the chart inside the <div> element with id="piechart"
            var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
            chart.draw(data, options);
        });

        // TODO pull changes from master, merge and organize. set up education & other fields
    }

//    ====================BEGIN BUTTONS FUNCTIONS TO DISPLAY DIFF STATISTICS===================*

    $(document).on('click', 'button', function() {
        var show = $(this).data('show');
        $(show).removeClass("hide").siblings().addClass("hide");
    });

    //    ====================END BUTTONS FUNCTIONS TO DISPLAY DIFF STATISTICS===================*


})();