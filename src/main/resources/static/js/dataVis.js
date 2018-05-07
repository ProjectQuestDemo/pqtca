
//PIE CHART JS

// Loads api for use
google.charts.load('current', {'packages': ['corechart']});
// google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
const drawChart = (url, header) => {
    fetch(url).then((response) => response.json()).then((jsonData) => {
        let arr = [header];
        for (const key of Object.keys(jsonData)) {
            arr.push([key, jsonData[key]]);
        }
        let data = google.visualization.arrayToDataTable(arr);
        // Optional; add a title and set the width and height of the chart
        let options = {'title': 'Demographics', 'width': 500, 'height': 250};
        // Display the chart inside the <div> element with id="piechart"
        let chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
    });
};
