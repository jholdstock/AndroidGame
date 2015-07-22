package com.jh.multiplayergame.games.quiz;

import java.util.Random;

public class QCountriesGame extends BaseQuizGame
{
	private String[] COUNTRIES = { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "The Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "The Gambia", "Georgia", "Germany", "Ghana", "Greece", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Namibia", "Nepal", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "Spain", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Thailand", "Togo", "Tonga", "Tunisia", "Turkey", "Turkmenistan", "Uganda", "Ukraine", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" };
	private String[] CAPITALS = { "Kabul", "Tirana", "Algiers", "Andorra la Vella", "Luanda", "Saint John's", "Buenos Aires", "Yerevan", "Canberra", "Vienna", "Baku", "Nassau", "Manama", "Dhaka", "Bridgetown", "Minsk", "Brussels", "Belmopan", "Porto-Novo", "Thimphu", "La Paz", "Sarajevo", "Gaborone", "Brasilia", "Bandar Seri Begawan", "Sofia", "Ouagadougou", "Bujumbura", "Phnom Penh", "Yaounde", "Ottawa", "Praia", "Bangui", "N'Djamena", "Santiago", "Beijing", "Bogota", "Moroni", "San Jose", "Yamoussoukro", "Zagreb", "Havana", "Nicosia", "Prague", "Copenhagen", "Djibouti", "Roseau", "Santo Domingo", "Quito", "Cairo", "San Salvador", "Malabo", "Asmara", "Tallinn", "Addis Ababa", "Suva", "Helsinki", "Paris", "Libreville", "Banjul", "Tbilisi", "Berlin", "Accra", "Athens", "Guatemala City", "Conakry", "Bissau", "Georgetown", "Port-au-Prince", "Tegucigalpa", "Budapest", "Reykjavik", "New Delhi", "Jakarta", "Tehran", "Baghdad", "Dublin", "Jerusalem", "Rome", "Kingston", "Tokyo", "Amman", "Astana", "Nairobi", "Pyongyang", "Seoul", "Pristina", "Kuwait City", "Bishkek", "Vientiane", "Riga", "Beirut", "Maseru", "Monrovia", "Tripoli", "Vaduz", "Vilnius", "Luxembourg", "Skopje", "Antananarivo", "Lilongwe", "Kuala Lumpur", "Male", "Bamako", "Valletta", "Majuro", "Nouakchott", "Port Louis", "Mexico City", "Chisinau", "Monaco", "Ulaanbaatar", "Podgorica", "Rabat", "Maputo", "Windhoek", "Kathmandu", "Wellington", "Managua", "Niamey", "Abuja", "Oslo", "Muscat", "Islamabad", "Melekeok", "Panama City", "Port Moresby", "Asuncion", "Lima", "Manila", "Warsaw", "Lisbon", "Doha", "Bucharest", "Moscow", "Kigali", "Basseterre", "Castries", "Kingstown", "Apia", "San Marino", "Sao Tome", "Riyadh", "Dakar", "Belgrade", "Victoria", "Freetown", "Singapore", "Bratislava", "Ljubljana", "Honiara", "Mogadishu", "Madrid", "Khartoum", "Paramaribo", "Mbabane", "Stockholm", "Bern", "Damascus", "Taipei", "Dushanbe", "Bangkok", "Lome", "Nuku'alofa", "Tunis", "Ankara", "Ashgabat", "Kampala", "Kyiv", "London", "Washington D.C.", "Montevideo", "Tashkent", "Port-Vila", "Caracas", "Hanoi", "Sanaa", "Lusaka", "Harare" };
	
	@Override
	public String getDescription()
	{
		return "Capital city matches country?";
	}
	
	@Override
	public QuestionAndAnswer getQuestionAndAnswer()
	{
		int country = new Random().nextInt(COUNTRIES.length);
		int capital;
		if (new Random().nextInt(3) == 0)
		{
			capital = country;
		}
		else
		{
			capital = new Random().nextInt(COUNTRIES.length);
		}
		
		String question = COUNTRIES[country] + "\n" + CAPITALS[capital];
		
		boolean answer = capital == country; 

		return new QuestionAndAnswer(question, answer);
	}
}
