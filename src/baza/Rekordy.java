package baza;

public class Rekordy {

	public static void addData() {
		Baza z = new Baza();
		z.insertStawka("2x805Na", 13.48);
		z.insertStawka("1x805Na", 8.76);
		z.insertStawka("Niskopod�ogowy", 16.78);
		z.insertStawka("Helmut", 8.56);
		z.insertOdcinek("Aleksandrowska", "KOCHAN�WKA-TEOFIL�W", 0.8f, 4);
		z.insertOdcinek("Aleksandrowska", "TEOFIL�W-DW.��D� �ABIENIEC", 3, 11);
		z.insertOdcinek("Limanowskiego", "DW.��D� �ABIENIEC-W��kniarzy", 0.8f, 1);
		z.insertOdcinek("Limanowskiego", "W��kniarzy-Zachodnia", 2, 8);
		z.insertOdcinek("Zgierska", "Targowisko Dolna-HELEN�WEK", 4.7f, 16);
		z.insertOdcinek("Warszawska", "Targowisko Dolna-MARYSIN WARSZAWSKA", 4, 17);
		z.insertOdcinek("Zachodnia", "Limanowskiego-Targowisko Dolna", 0.35f, 2);
		z.insertOdcinek("Zgierska", "Limanowskiego-Targowiska Dolna", 0.45f, 2);
		z.insertOdcinek("Limanowskiego", "Zachodnia-Zgierska", 0.2f, 2);
		z.insertOdcinek("W��kniarzy", "Srebrzy�ska-Limanowskiego", 2.2f, 7);
		z.insertOdcinek("W��kniarzy", "Legion�w-Srebrzy�ska", 0.5f, 2);
		z.insertOdcinek("Zachodnia", "Ogrodowa-Limanowskiego", 1, 5);
		z.insertOdcinek("Zgierska", "Wojska Polskiego-Limanowskiego", 0.35f, 2);
		z.insertOdcinek("Nowomiejska", "PLAC WOLNO�CI-Wojska Polskiego", 0.75f, 6);
		z.insertOdcinek("Wojska Polskiego", "Zgierska-Franciszka�ska", 0.5f, 2);
		z.insertOdcinek("Wojska Polskiego", "Franciszka�ska-STRYKOWSKA", 2.7f, 10);
		z.insertOdcinek("Franciszka�ska", "P�nocna-Wojska Polskiego", 0.55f, 2);
		z.insertOdcinek("Ogrodowa", "Zachodnia-Nowomiejska", 0.15f, 1);
		z.insertOdcinek("Zachodnia", "Legion�w-Ogrodowa", 0.25f, 1);
		z.insertOdcinek("Kili�skiego", "Pomorska-P�nocna", 0.25f, 2);
		z.insertOdcinek("Srebrzy�ska-Cmentarna", "KOZINY-Legion�w", 1.5f, 5);
		z.insertOdcinek("Legion�w", "Cmentarna-Gda�ska", 0.3f, 2);
		z.insertOdcinek("Legion�w", "Gda�ska-Zachodnia", 0.3f, 2);
		z.insertOdcinek("Legion�w", "Zachodnia-PLAC WOLNO�CI", 0.2f, 1);
		z.insertOdcinek("Pomorska", "PLAC WOLNO�CI-Kili�skiego", 0.5f, 3);
		z.insertOdcinek("Pomorska", "Kili�skiego-Konstytucyjna", 2.4f, 11);
		z.insertOdcinek("Pomorska", "Konstytucyjna-wiadukt", 0.4f, 1);
		z.insertOdcinek("Pomorska", "Wiadukt-CKD SZPITAL", 0.4f, 2);
		z.insertOdcinek("Dzia�ki", "Wiadukt-TELEFONICZNA ZAJEZDNIA", 0.7f, 3);
		z.insertOdcinek("Telefoniczna", "TELEFONICZNA ZAJEZDNIA-STOKI", 1.7f, 8);
		z.insertOdcinek("Zdrowie", "ZDROWIE-Konstantynowska", 0.3f, 1);
		z.insertOdcinek("Konstantynowska", "Zdrowie-W��kniarzy", 1.4f, 5);
		z.insertOdcinek("Legion�w", "W��kniarzy-Zielona", 0.2f, 1);
		z.insertOdcinek("Legion�w", "Zielona-Cmentarna", 1.2f, 5);
		z.insertOdcinek("Zielona", "Legion�w-Gda�ska", 1.5f, 7);
		z.insertOdcinek("Gda�ska", "Zielona-Legion�w", 0.7f, 3);
		z.insertOdcinek("Zachodnia", "Zielona-Legion�w", 0.7f, 3);
		z.insertOdcinek("Zielona", "Gda�ska-Ko�ciuszki", 0.3f, 2);
		z.insertOdcinek("Narutowicza", "Zachodnia-Kili�skiego", 0.7f, 4);
		z.insertOdcinek("Kili�skiego", "Narutowicza-Pomorska", 0.7f, 4);
		z.insertOdcinek("Narutowicza", "Kili�skiego-P.O.W.", 0.25f, 1);
		z.insertOdcinek("Nowow�glowa", "Kili�skiego-P.O.W.", 0.25f, 1);
		z.insertOdcinek("P.O.W.", "Nowow�glowa-Narutowicza", 0.2f, 1);
		z.insertOdcinek("Nowow�glowa", "P.O.W.-Tramwajowa", 0.7f, 3); //46->44
		z.insertOdcinek("Narutowicza", "P.O.W.-Tramwajowa", 0.7f, 3);
		z.insertOdcinek("Tramwajowa", "Nowow�glowa-Narutowicza", 0.2f, 1);
		z.insertOdcinek("Nowow�glowa", "Tramwajowa-Kopci�skiego", 0.45f, 2);
		z.insertOdcinek("Narutowicza", "Tramwajowa-Kopci�skiego", 0.45f, 2);
		z.insertOdcinek("Narutowicza", "Kopci�skiego-RADIOSTACJA", 0.9f, 3);
		z.insertOdcinek("Konstytucyjna", "RADIOSTACJA-Pomorska", 0.45f, 1);
		z.insertOdcinek("W��kniarzy", "Legion�w-Kopernika", 1.5f, 3);
		z.insertOdcinek("W��kniarzy", "Kopernika-Mickiewicza", 0.1f, 1);
		z.insertOdcinek("Kopernika", "W��kniarzy-�eromskiego", 1.1f, 6);
		z.insertOdcinek("Gda�ska", "�eromskiego-Zielona", 1, 4);
		z.insertOdcinek("Ko�ciuszki", "Mickiewicza-Zielona", 1.3f, 6);
		z.insertOdcinek("Kili�skiego", "Narutowicza-Nowow�glowa", 0.3f, 1);
		z.insertOdcinek("Kili�skiego", "Nowow�glowa-Pi�sudskiego", 1, 5);
		z.insertOdcinek("Kopci�skiego", "Pi�sudskiego-Nowow�glowa", 0.7f, 2);
		z.insertOdcinek("�eromskiego", "Wr�blewskiego-Kopernika", 2, 9);
		z.insertOdcinek("Wyszy�skiego", "WYSZY�SKIEGO-BRATYS�AWSKA", 2.7f, 8);
		z.insertOdcinek("Bratys�awska-Bandurskiego", "BRATYS�AWSKA-W��kniarzy", 1.6f, 4);
		z.insertOdcinek("Mickiewicza", "W��kniarzy-Ko�ciuszki", 1.5f, 5);
		z.insertOdcinek("Mickiewicza", "Ko�ciuszki-Piotrkowska", 0.2f, 1);
		z.insertOdcinek("Piotrkowska", "�wirki-Pi�sudskiego", 0.4f, 2);
		z.insertOdcinek("�wirki", "Piotrkowska-Mickiewicza", 0.4f, 2);
		z.insertOdcinek("Pi�sudskiego", "Piotrkowska-Kili�skiego", 0.7f, 3);
		z.insertOdcinek("Pi�sudskiego", "Kili�skiego-Kopci�skiego", 1.1f, 4);
		z.insertOdcinek("Pi�sudskiego", "Kopci�skiego-WIDZEW STADION", 2.3f, 6);
		z.insertOdcinek("Rokici�ska", "WIDZEW STADION-Puszkina", 1.3f, 4);
		z.insertOdcinek("Rokici�ska", "Puszkina-WIDZEW AUGUST�W", 1.2f, 2);
		z.insertOdcinek("Rokici�ska-Hetma�ska-Odnowiciela-Al.Ofiar Terroryzmu 11 Wrze�nia", "WIDZEW AUGUST�W-OLECH�W", 4.5f, 11);
		z.insertOdcinek("Politechniki", "RLL-Wr�blewskiego", 1.4f, 5);
		z.insertOdcinek("Wr�blewskiego-W�lcza�ska-Czerwona", "Politechniki-Piotrkowska", 0.8f, 5);
		z.insertOdcinek("Piotrkowska", "Czerwona-�wirki", 1.1f, 5);//74
		z.insertOdcinek("Piotrkowska", "Przybyszewskiego-Czerwona", 0.35f, 1);
		z.insertOdcinek("Piotrkowska", "Przybyszewskiego-PLAC NIEPODLEG�O�CI", 0.35f, 1);
		z.insertOdcinek("Kili�skiego", "Przybyszewskiego-Pi�sudskiego", 1.7f, 6);
		z.insertOdcinek("�mig�ego-Rydza", "Przybyszewskiego-Pi�sudskiego", 1.6f, 6);
		z.insertOdcinek("Puszkina", "Lodowa-Rokici�ska", 1.7f, 6);
		z.insertOdcinek("Przybyszewskiego", "Piotrkowska-Kili�skiego", 1, 4);
		z.insertOdcinek("Przybyszewskiego", "Kili�skiego-�mig�ego-Rydza", 1, 5);
		z.insertOdcinek("Przybyszewskiego", "�mig�ego-Rydza-Lodowa", 2.2f, 8);
		z.insertOdcinek("Lodowa", "Przybyszewskiego-CM. ZARZEW", 0.25f, 2);
		z.insertOdcinek("Kili�skiego", "D�browskiego-Przybyszewskiego", 0.8f, 3);
		z.insertOdcinek("�mig�ego-Rydza", "D�browskiego-Przybyszewskiego", 1.1f, 3);
		z.insertOdcinek("Rzgowska", "D�browskiego-PL. NIEPODLEG�O�CI", 0.35f, 2);
		z.insertOdcinek("D�browskiego", "Rzgowska-Kili�skiego", 0.8f, 3);
		z.insertOdcinek("D�browskiego", "Kili�skiego-�mig�ego-Rydza", 0.7f, 3);
		z.insertOdcinek("D�browskiego", "�mig�ego-Rydza-DW. ��D� D�BROWA", 2.1f, 5);
		z.insertOdcinek("Pabianicka", "RLL-PLAC NIEPODLEG�O�CI", 1.1f, 5);
		z.insertOdcinek("Pabianicka", "ZAJ.CHOCIANOWICE-RLL", 3.2f, 10);
		z.insertOdcinek("Paderewskiego", "RLL-Rzgowska", 1.8f, 7);
		z.insertOdcinek("Rzgowska", "Paderewskiego-D�browskiego", 1, 5);
		z.insertOdcinek("Broniewskiego", "Rzgowska-Kili�skiego", 0.25f, 2);
		z.insertOdcinek("Kili�skiego", "Broniewskiego-D�browskiego", 0.7f, 2);
		z.insertOdcinek("Kili�skiego", "DW.��D� CHOJNY-Broniewskiego", 0.5f, 2);
		z.insertOdcinek("�mig�ego-Rydza", "Broniewskiego-D�browskiego", 0.5f, 4);
		z.insertOdcinek("Rzgowska", "Paderewskiego-CHOJNY KURCZAKI", 1.5f, 6);
		z.insertOdcinek("Rzgowska", "CHOJNY KURCZAKI-INSTYTUT CZMP", 2.1f, 7);
		z.insertOdcinek("��dzka (Zgierz)", "HELEN�WEK-1 Maja (Zgierz)", 2.1f, 6);
		z.insertOdcinek("1 Maja (Zgierz)", "��dzka (Zgierz)-ZGIERZ(PLAC KILI�SKIEGO)", 0.9f, 5);
		z.insertOdcinek("��dzka (Zgierz)-��czycka (Zgierz)", "1 Maja (Zgierz)-OZORK�W TR�JK�T", 15.4f, 45);
		z.insertOdcinek("Ozork�w", "OZORK�W TR�JK�T-OZORK�W CEGIELNIANA", 1.5f, 4);
		z.insertOdcinek("Konstantynowska", "ZAJEZDNIA MUZEALNA BRUS-Zdrowie", 2.2f, 11);
		z.insertOdcinek("Konstantyn�w", "LUTOMIERSK-KONSTANTYN�W", 7.6f, 32);
		z.insertOdcinek("Ksawer�w", "CHOCIANOWICE IKEA-DU�Y SKR�T", 4.3f, 12);
		z.insertOdcinek("�aska (Pabianice)-Zamkowa (Pabianice)-Warszawska (Pabianice)-��dzka (Pabianice)", "WIEJSKA (PABIANICE)-DU�Y SKR�T", 5.2f, 19);
		z.insertOdcinek("Kopci�skiego", "Nowow�glowa-Narutowicza", 0.6f, 2);
		z.insertOdcinek("Strykowska", "STRYKOWSKA-DW.��D� MARYSIN", 0.3f, 2);
		z.insertOdcinek("OZORK�W (TR�JK�T)", "p�tla", 0, 0);
		z.insertOdcinek("ZGIERZ (PLAC KILI�SKIEGO)", "p�tla", 0, 0);
		z.insertOdcinek("HELEN�WEK (P�TLA)", "p�tla", 0, 0);
		z.insertOdcinek("ZAJ.HELEN�WEK", "p�tla", 0, 0);
		z.insertOdcinek("KOCHAN�WKA", "p�tla", 0, 0);
		z.insertOdcinek("TEOFIL�W", "p�tla", 0, 0);
		z.insertOdcinek("DW. ��D� �ABIENIEC", "p�tla", 0, 0);
		z.insertOdcinek("MARYSIN WARSZAWSKA", "p�tla", 0, 0);
		z.insertOdcinek("DW. ��D� MARYSIN", "p�tla", 0, 0);
		z.insertOdcinek("DO�Y", "p�tla", 0, 0);
		z.insertOdcinek("LUTOMIERSK", "p�tla", 0, 0);
		z.insertOdcinek("KONSTANTYN�W ��DZKI", "p�tla", 0, 0);
		z.insertOdcinek("ZDROWIE", "p�tla", 0, 0);
		z.insertOdcinek("KOZINY", "p�tla", 0, 0);
		z.insertOdcinek("W��KNIARZY LEGION�W", "p�tla", 0, 0);
		z.insertOdcinek("PӣNOCNA", "p�tla", 0, 0);
		z.insertOdcinek("PLAC WOLNO�CI", "p�tla", 0, 0);
		z.insertOdcinek("ZAJ.TELEFONICZNA", "p�tla", 0, 0);
		z.insertOdcinek("STOKI", "p�tla", 0, 0);
		z.insertOdcinek("TELEFONICZNA ZAJEZDNIA", "p�tla", 0, 0);
		z.insertOdcinek("CKD SZPITAL", "p�tla", 0, 0);
		z.insertOdcinek("RADIOSTACJA", "p�tla", 0, 0);
		z.insertOdcinek("DW. ��D� FABRYCZNA", "p�tla", 0, 0);
		z.insertOdcinek("RETKINIA", "p�tla", 0, 0);
		z.insertOdcinek("KAROLEW", "p�tla", 0, 0);
		z.insertOdcinek("PIOTRKOWSKA CENTRUM", "p�tla", 0, 0);
		z.insertOdcinek("WIDZEW STADION", "p�tla", 0, 0);
		z.insertOdcinek("WIDZEW AUGUST�W", "p�tla", 0, 0);
		z.insertOdcinek("CM. ZARZEW", "p�tla", 0, 0);
		z.insertOdcinek("OLECH�W", "p�tla", 0, 0);
		z.insertOdcinek("PL. NIEPODLEG�O�CI", "p�tla", 0, 0);
		z.insertOdcinek("DW. ��D� D�BROWA", "p�tla", 0, 0);
		z.insertOdcinek("R. LOTN. LWOWSKICH", "p�tla", 0, 0);
		z.insertOdcinek("DW.��D� CHOJNY", "p�tla", 0, 0);
		z.insertOdcinek("D�BROWA NI�SZA", "p�tla", 0, 0);
		z.insertOdcinek("ZAJ.CHOCIANOWICE", "p�tla", 0, 0);
		z.insertOdcinek("CHOCIANOWICE IKEA", "p�tla", 0, 0);
		z.insertOdcinek("DU�Y SKR�T", "p�tla", 0, 0);
		z.insertOdcinek("PABIANICE (WIEJSKA)", "p�tla", 0, 0);
		z.insertOdcinek("CHOJNY KURCZAKI", "p�tla", 0, 0);
		z.insertOdcinek("INSTYTUT CZMP", "p�tla", 0, 0);
		z.insertOdcinek("OZORK�W (CEGIELNIANA)", "p�tla", 0, 0);
		z.insertOdcinek("Broniewskiego", "Kili�skiego-Ni�sza", 0.7f, 2);
		z.insertOdcinek("Ni�sza", "D�BROWA NI�SZA-Broniewskiego", 0.5f, 4);
		z.insertOdcinek("Al.Ofiar Terroryzmu 11 Wrze�nia-Odnowiciela-Hetma�ska-Rokici�ska", "WIDZEW AUGUST�W-OLECH�W", 4.5f, 11);
		z.insertOdcinek("Konstantynowska", "KONSTANTYN�W-ZAJEZDNIA MUZEALNA BRUS", 4.8f, 18);
		z.insertOdcinek("ZAJEZDNIA MUZEALNA BRUS", "p�tla", 0, 0);	
		z.insertOdcinek("Pabianicka", "CHOCIANOWICE IKEA-ZAJ.CHOCIANOWICE", 1.1f, 4);
		z.insertOdcinek("P�nocna", "Nowomiejska-Kili�skiego", 0.5f, 2);
	}
}
