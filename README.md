<h4>Описание:</h4>
Анализирует pdf-файл, ищет в нем ключевые слова, вставляет рекомендательные ссылки для прочтения по найденным ключевым словам.<br><br>
В файле data/config заполняются те рекомендации, которые делает приложение.<br>
В каждой строке по три части, разделённых tab:<br>
<ul>
<li>первая часть это ключевое слово, на которое должно реагировать приложение;
<li>вторая часть это заголовок для рекомендуемой ссылки;
<li>третья часть это сама рекомендуемая ссылка. </ul>
В папке data/pdfs находятся pdf-файлы, которые надо обработать.<br> 
В папку data/converted должны будут сохраняться результат редактирования.<br>

<h4>Требование:</h4>
<ol>
<li> Если в тексте страницы встречается ключевое слово, то после этой страницы должна быть создана новая пустая страница и для каждого встреченного слова 
вставлена в неё рекомендуемая ссылка.
<li> Если для какого-то ключевого слова в этой pdf уже была рекомендация, то повторяться она уже не должна.
<li> Проверка встречаемости должна игнорировать регистр текста, т.е. при поиске слова объект должны подходить и объект, и Объект.  
<li> В конфигурационном файле каждая строка должна состоять из трёх частей, а если не так, то кидать своё исключение WrongLinksFormatException.
</ol>

<h4>Стек технологий:</h4>
Java 11, Maven, iTextpdf, JUnit, Logback
