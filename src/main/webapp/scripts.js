
            function loadFilms() {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', 'getfilms', false);
                xhr.send();
                if (xhr.status != 200) {
                    // обработать ошибку
                    alert('Ошибка ' + xhr.status + ': ' + xhr.statusText);
                } else {
                    return xhr.responseText;
                }
            }

            function getFilms() {
                var films = JSON.parse(loadFilms());
                alert(films[0];

                for (i=0, i <= films.length, i++){
					var film = document.createElement('div');
                film.className = "film";
                film.innerHtml = films[i].name;
                allFilms.appendChild(film);
				}
                
            }
