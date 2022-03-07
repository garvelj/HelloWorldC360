# HelloWorldC360
Zadatak

Mali log onoga sto sam radio i podsjetnik.
Uradio sam prve tri tacke, sa cetvrtom nisam mogao da se snadjem jer sam imao problema 
sa thymeleafom jer nije htio maven da ucita njegove dependencyje
kad sam to rijesio, shvatio kako se prebacuju parametri iz urla u kontroler i iz kontrolera
u html. Međutim, nisam shvatio kako da pošaljem objekat do htmla.
Repo sam izbrisao jer je pravio probleme sa pokretanjem na ovako nedovršenom programu. 

1. Sa Spring Initializr napravio fajl sa WEB, H2 i još jednim database dependencyom JPA
2. Dodat samo jedan endpoint koji ispisuje 'hello world' i zove se hello
3. Napravljen directory 'Public' gdje sam spakovao html fajl koji ispisuje 

	Edit 4.2.2022: Da bi se pokretala html stranica treba da se napravi Controller.
	HTML fajl mora biti smjesten u Public direktorijum i Controller mora da vraca
	'ime.html'. Kada pisem @RequestMapping("/hello") treba da stavljam ovaj slash. 

	U application.properties moze da se podesi da po defaultu da html stranice 
	budu procitane i obradjene kao taj tip podatka, tako sto upisemo:
	spring.mvc.view.suffix=.html
	
	A za direktorijum u kom se nalazi pisemo:
	spring.mvc.view.prefix=/pages/ ako je pages ime direktorijuma

Šta je repository?
	Mehanizam za skladištenje objekata? 
	Edit: Repository je tu kao interfejs gdje se nalaze metode za pristup bazi
	odnosno iskoristen je kao business layer (?)

4. Imao sam problem da pristupim h2 bazi podataka jer nije imao (?) neki fajl na users
	u application.properties dodao liniju: 
		spring.datasource.url = jdbc:h2:mem:testdb
	da bih mu pokazao gdje je izvoriste baze, a onda pri konektovanju kao JDBC URL 
dao sledecu adresu 
		jdbc:h2:mem:testdb

	Edit: da bi se omogucio pristup h2 bazi treba da se enableuje njena konzola
	to se radi linijom u application.properties: spring.h2.conslole.enabled=true
	trebace i spring.datasource.platform=h2
	pa tek posle toga ide spring.datasource.url koja moze biti po defaultu napravljena

@Component - kreira objekt klase u Springu (jer ne može da se koristi standardna Java 
klasa, mora da se poveže sa springom, odnosno da se od nje napravi Spring Bean). Stavlja
se na vrh klase.

@Autowired - za objekat klase koji je dependent o nekoj drugoj klasi mora da se navede
da bi prvi potrazio objekat o kom je zavisan unutar Spring Containera 

Ako se trazi neka specificna klasa, trazi se po njenom imenu kao:
Umjesto @Autowired koristi se kljucna rijec:
@Qualifier("laptop") gdje je laptop ime klase o kojoj je prva zavisna 

@Service - koristi se u business layeru koji se koristi da poveze 
Repo sa User interfaceom 

Ponovo na 4. tacki: 
	@Entity nam pokazuje sta je entitet baze podataka

	@RequestParam anotacija se koristi da bi se preuzeo parametar iz URLa 

Ponovo sve aosghalcaso

Mora se sve strpati u root folder da bi radilo kako valja 


Da bi Tomcat slusao drugi port potrebno je u application.properties unijeti sledecu
liniju:   
	 server.port=8000, 
gdje je 8000 port koji se slusa 

@Entity govori da je klasa koja je u pitanju JPA entitet

RequestMethod. 
		  GET - dohvata listu iz repozitoryja
		  POST - vezuje podatke u tijelu zahtjeva za objekat nase klase

#np Georges Bizet - Habanera

Problemi kojima ne mogu uci u trag:
	Thymeleaf ne responduje 
	Samim time -> passing parameters ne funkcionise 
	H2 sam pristupio Ali nisam uspio da kreiram tabelu koja trajno ostaje tu

Da bih proslijedio parametar iz Springa u HTML treba mi Model u metodi koja ga 
proslijedjuje. 
Takodje, treba mi promjenljiva koja prima vrijednost iz URLa. Da bi Spring
znao da je u pitanju parametar dodaje se anotacija:
@RequestParam(value="latitude") gdje je latitude ime promjenljive koju cemo 
koristiti u nasoj metodi.

Da bi thymeleaf radio u html tagu mora da se navede sledece: 
<html xmlns:th="http://www.thymeleaf.org">

Uspio sama da proturim parametar do HTMLa, evo primjer koda za svaki slucaj da
ostane ako zaboravim kako se to radi:

package nn.ble;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class hello {

    @RequestMapping(value = "/hellno", method = RequestMethod.GET)
    public String hello(Model model, @RequestParam(value = "name", required = false) String name){
        model.addAttribute("name", name)
        return "hellno";
    }
}

Sta treba da primijetim ovdje jeste da moram da navedem ovaj dio required = false 
Jer je default vrijednost true i nece pokretati stranicu ako nema parametar.
Drugo, mora da se doda Model pri deklaraciji metoda i kasnije da se iskoristi da
bi se uveo parametar. 

Oke napravio sam H2 bazu, odnosno pristupio njoj tako da cita moju tabelu tako sto 
sam u klasi naveo anotacije @Entity i @Id. Problem je sto mi ne cita SQL fajl koji 
sam napravio da bih ubacio vise objekata u tabelu. 



------------------------------------------------------------------------------
RomanianCoder 
Amigoscode 
Dan Vega
Brandan Jones
Kindson The Tech Pro

Baeldung.com
Thymeleaf.org

Spring Boot In Action - Craig Walls
Spring Documentation
Thymeleaf Documentation
