package es.unileon.prg1.date;


public class Date {
	private int day;
	private int month;
	private int year;


	public Date(){
		this.day = 6;
		this.month = 8;
		this.year = 2002;
	}

	
	public Date (int day, int month, int year) throws DateException {
		this.year = year;
		if (month>=1 && month<=12) {
			this.month = month;
		}else {
			throw new DateException ("el mes"+month+"no es valido, introduce un valor entre 1 y 12");
		}
		switch (this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day >= 1 && day <= 31) {
					this.day=day;
				}else {
					throw new DataException("el dia"+day+"no existe en este mes");
				}
				this.month=month;
				break;
			case 2:
				if (day>=1 && day>= 29) {
					this.day=day;
				}else {
					throw new DataException("el dia"+day+"no existe en este mes");
				}
				this.month=month;
				break;
		}
	}
	
	public void setDay(int day) throws DateException { //compruebo el dia
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException { // Compruebo el mes
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	// gets

	public getDay(){
		return this.day;		// Devuelve el dia
	}
	public getMonth(){
		return this.month;		//Devuelve el mes
	}
	public getYear(){
		return this.year;		//Devuelve el año
	}



/*
*	METODOS PARA COMPARAR YEAR, MONTH Y DAY
*
*			CON IF
*
**/

	public boolean isSameYear(Date date) {
		if (this.getYear()==getYear()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean isSameMonth(Date date) {
		if (this.getMonth()==getMonth()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isSameDay(Date date) {
		if (this.getDay()==getDay()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean isSame(Date date) {
		if (isSameDay(date) && isSameMonth(date) && isSameYear(date)) {
			return true;
		}else {
			return false;
		}
	}

	/*
*	METODOS PARA COMPARAR YEAR, MONTH Y DAY
*
*				SIN IF
*
**/
	public boolean isSameDay2(Date date){
		return this.getDay()==getDay();
	}
	public boolean isSameMonth2(Date date){
		return this.getMonth()==getMonth();
	}
	public boolean isSameYear2(Date date){
		return this.getYear()==getYear();
	}
	public boolean isSame2(Date date){
		return isSameDay(date) && isSameYear(date) && isSameMonth(date);
	}


	public String toString() {
		return this.day+"/"+this.month+"/"+this.year; //Devuelve un string con la fecha
	}
	

	//Metodo que nos devuelve el nombre del mes
	public String getMonthName(){
		StringBuilder monthName = new StringBuilder();
		switch(this.month){

			case 1:
				monthName.append("Enero");
				break;
			case 2:
				monthName.append("Febrero");
				break;
			case 3:
				monthName.append("Marzo");
				break;
			case 4:
				monthName.append("Abril");
				break;
			case 5:
				monthName.append("Mayo");
				break;
			case 6:
				monthName.append("Junio");
				break;
			case 7:
				monthName.append("Julio");
				break;
			case 8:
				monthName.append("Agosto");
				break;
			case 9:
				monthName.append("Septiembre");
				break;
			case 10:
				monthName.append("Octubre");
				break;
			case 11:
				monthName.append("Noviembre");
				break;
			case 12:
				monthName.append("Diciembre");
				break;

			return monthName.toString();
		}

	}




// Devuelve los meses que faltan para acabar el anio


	public String getMonthsLeft(){

		StringBuffer meses = new StringBuffer();
		int month=this.month;
		Date fecha = this;

		for(int i = this.month; i < 12; i++){
			month++;
		try {
			fecha.setMonth(month);
		} catch (DateException e) {
			e.printStackTrace();
		}

		meses.append(fecha.getMonthName() + " ");

		}	

		return meses.toString();
	}





	//Metodo que devuelve la estacion del año en la que estamos
	public String getSeason(){
		StringBuilder season = new StringBuilder();
		switch(this.month){

			case 9:
			case 10:
			case 11:
				season.append("Otonyo");
				break;

			case 12:
			case 1:
			case 2:
				season.append("Invierno");
				break;

			case 3:
			case 4:
			case 5:
				season.append("Primavera");
				break;

			case 6:
			case 7:
			case 8:
				season.append("Verano");
				break;

		}

		return season.toString();

	}


	
	//Imprime los meses con el mismo numero de dias que el mes de la fecha

	public String getMonthsSameDays(){

		String meses = " ";

		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				meses = "January March May July August October December ";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				meses = "April June September November ";
				break;
			default:
				meses = "February ";
		}

		return meses;
	}





	//devuelve los dias restantes para que acabe el mes
	public String getRestDays(){
		StringBuilder salida = new StringBuilder();
		switch (this.month) {
			case 1:
			case 3:
			case 5:	
			case 7:
			case 8:	
			case 10:
			case 12:
				for (int i=this.day+1; i<=31; ++i) {
					salida.append(i+"/"+this.month+"/"+this.year);
					break;
				}
			case 2:
				for (int i =this.day+1; i<=28; ++i) {
					salida.append(i+"/"+this.month+"/"+this.year);
					break;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				for (int i =this.day+1; i<=30; ++i) {
					salida.append(i+"/"+this.month+"/"+this.year);
					break;
				}
		return salida.toString();	
		}
	}
	
	public String 




	//Dias desde principio de anio hasta la fecha

	public int daysPast() throws DateException{

		int nums = 0;

		if(this.getMonth() == 1 && this.getDay() != 1) {
			nums += this.getDay()-1;
		}else {
			int mes = this.getMonth();
			for(int i = 1; i < this.month ; i++) {
				this.setMonth(i);
				nums = nums + this.daysOfMonth();
			}
			if(this.getDay() == 31 && mes == 12 ) {
				nums = 365 - (daysOfMonth() - getDay())-1;
			}
		}
		return nums;
	}


	//Numero de intentos hasta general una fecha aleatoria igual que la fecha introducida

	public int numRandomTriesEqualDateWhile(){

		int day2_ = 0;
		int month2_ = 0;
		int attemps2 = 0;

		while((day2_ != this.day) && (month2_ != this.month)){
			day2_ = (int)((Math.random()*31)+1);
			month2_ = (int)((Math.random()*12)+1);
			attemps2 = attemps2 + 1;
		}

		return attemps2;
	}


	//Numero de intentos hasta general una fecha aleatoria igual que la fecha introducida

	public int numRandomTriesEqualDateDoWhile(){

		int day_ = 0;
		int month_ = 0;
		int attemps = 0;

		do{
			day_ = (int)((Math.random()*31)+1);
			month_ = (int)((Math.random()*12)+1);
			attemps = attemps +1;
		}while((day_ != this.day) && (month_ != this.month));

		return attemps;
	}

	//Devuelve el dia de la semana en el que se encuentra la fecha

	public String dayOfWeek(int day) throws DateException {

		String valor_dia = " ";
		int diaSemana = this.daysPast() % 7;

		switch(diaSemana) {
			case 0:
				valor_dia = "Monday";
				break;
			case 1:
				valor_dia = "Tuesday";
				break;
			case 2:
				valor_dia = "Wednesday";
				break;
			case 3:
				valor_dia = "Thursday";
				break;
			case 4:
				valor_dia = "Friday";
				break;
			case 5:
				valor_dia = "Saturday";
				break;
			case 6:
				valor_dia = "Sunday";
				break;
		}    
   		return valor_dia;
	}

}


