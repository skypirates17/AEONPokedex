<%@include file="jspf/header.jspf"%>

<div data-role="main" class="ui-content">
	<form class="ui-filterable">
		<input id="myFilter" data-type="search">

		<ul class="ui-listview ui-listview-inset" id="pokemon-list" data-role="listview" data-filter="true" data-input="#myFilter" 
			data-inset="true" >
			<c:forEach var="pokemon" items="${pokemonList}" varStatus="status">
				<li class="ui-btn ui-btn-icon-right ui-li-has-arrow ui-li ui-li-has-thumb ui-first-child ui-btn-up-c"
					id='${pokemon.number}' data-icon="arrow-r" data-iconpos="right" data-wrapperEls="div" data-theme="c">
					<div class = "ui-btn-inner ui-li" >
						<div class="ui-btn-text">
							<a class ="ui-link-inherit" href="#">
								<img class="ui-li-thumb" src='images/pokemon/<c:out value="${pokemon.imageFileName}" />' />
								<h2 class="ui-li-heading"><c:out value="${pokemon.name}" /></h2>
								<p class="ui-li-desc">#<c:out value="${pokemon.number}" /></p>
							</a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</form>
</div>

<%@include file="jspf/footer.jspf"%>
