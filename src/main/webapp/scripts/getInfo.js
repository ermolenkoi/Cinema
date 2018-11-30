

function loadSchedule (form) {
    alert('loadSchedule')
    var date = 'http://localhost:8080/cinema/getSchedule?date=' + document.getElementById('dateSchedule').value;
    var xhr = new XMLHttpRequest();
    xhr.open('GET', date, false);
    xhr.send();
    if (xhr.status != 200) {
        alert('Ошибка ' + xhr.status + ': ' + xhr.statusText);
    } else {
		writeSeances(xhr.responseText);
    }
}

function writeSeances(seancesJSON){
    alert(seancesJSON);

    var seances = JSON.parse(seancesJSON);
    alert(seances);
    
	var content = document.getElementById('content');

	for (i = 0; i < seances.length; i++) {
		var film = document.createElement('div');
		film.className = 'film';
		film.id = seances[i].id;
		
		var filmposter = document.createElement('div');
		filmposter.className = 'film-poster';
		filmposter.innerHTML = '<img src="../pic/poster.jpg" width="240" height="360">';
		
		var filmdetail = document.createElement('div');
		filmdetail.className = 'film-detail';
		filmdetail.innerHTML = '<h3 class="film-title">' + seances.[i].filmName + '<p class="film-genre">фэнтези, приключения, экшн<span class="age">12+</span></p>';
		
		var filmcinema = document.createElement('div');
		filmcinema.className = 'film-cinema';
		
		for (i = 0; i < seances.dtoCinemas.length; i++) {
			var filmseances = document.createElement('div');
			filmseances.className = 'film-seances';
			var filmseanceshall = document.createElement('div');
			filmseanceshall.className = 'film-seances-hall';
			filmseanceshall.innerHTML = seances.dtoCinemas[i].hallName;
			
			for (i = 0; i < seances.dtoCinemas.dtoSeances.length; i++) {
				var filmseancesitem = document.createElement('div');
				filmseancesitem.className = 'film-seances-item';
				filmseancesitem.id = seances.dtoCinemas.dtoSeances[i].id;
				
				var seance = document.createElement('a');
				seance.className = 'seance';
				seance.innerHTML = seances.dtoCinemas.dtoSeances[i].startSeance.time.hour + ':' +
								   seances.dtoCinemas.dtoSeances[i].startSeance.time.minute;
				
				var seanceprice = document.createElement('div');
				seanceprice.className = 'seance-price';
				seanceprice.innerHTML = seances.dtoCinemas.dtoSeances[i].priceTicket;
				
				var seanceformat = document.createElement('div');
				seanceformat.className = 'seance-format';
				seanceformat.innerHTML = seances[i].typeVideo;
				
				filmseancesitem.appendChild(seance);
				filmseancesitem.appendChild(seanceprice);
				filmseancesitem.appendChild(seanceformat);
				
			}
			
			filmseanceshall.appendChild(filmseancesitem);
			
		}
		
		content.appendChild(film);
	}
	

	

	

	filmseances.appendChild(filmseanceshall);
	filmseances.appendChild(filmseancesitem);

	filmcinema.appendChild(filmseances);

	filmdetail.appendChild(filmcinema);

	content.appendChild(filmposter);
	content.appendChild(filmdetail);
	
}