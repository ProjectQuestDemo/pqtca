
//PIE CHART JS

// Loads api for use
google.charts.load('current', {'packages': ['corechart']});
// google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart(url, header) {

    //Fetch by Ethnicity
    fetch(url).then((response) => response.json()).then((jsonData) => {
        var arr = [header];
        for (const key of Object.keys(jsonData)) {
            arr.push([key, jsonData[key]]);
        }

        var data = google.visualization.arrayToDataTable(arr);

        // Optional; add a title and set the width and height of the chart
        var options = {'title': 'Demographics', 'width': 500, 'height': 250};

        // Display the chart inside the <div> element with id="piechart"
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
    });
}
