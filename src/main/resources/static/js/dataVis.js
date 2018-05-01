(function () {
    /*
        Uses Google Chart API
    */

    // Loads api for use
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
    function drawChart() {
        // var data = google.visualization.arrayToDataTable([
        //     ['Task', 'Hours per Day'],
        //     ['Work', 8],
        //     ['Friends', 2],
        //     ['Eat', 2],
        //     ['TV', 3],
        //     ['Gym', 2],
        //     ['Sleep', 7]
        // ]);

        //Fetch by Ethnicity
        fetch('/graphEthnicity').then((response) => response.json()).then((jsonData) => {
            var arr = [['Ethnicity', 'Number Of Applicants']];
            for(const key of Object.keys(jsonData)) {
                arr.push([key, jsonData[key]]);
            }

            var data = google.visualization.arrayToDataTable(arr);

            // Optional; add a title and set the width and height of the chart
            var options = {'title': 'Demographics', 'width': 500, 'height': 300};

            // Display the chart inside the <div> element with id="piechart"
            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
        });

        //Fetch by Education, education must be inserted into application table for this to work
        fetch('/graphEducation').then((response) => response.json()).then((jsonData) => {
            var arr = [['Education', 'Number Of Applicants']];
            for(const key of Object.keys(jsonData)) {
                arr.push([key, jsonData[key]]);
            }

            var data = google.visualization.arrayToDataTable(arr);

            // Optional; add a title and set the width and height of the chart
            var options = {'title': 'Demographics', 'width': 500, 'height': 300};

            // Display the chart inside the <div> element with id="piechart"
            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
        });
    }
})();