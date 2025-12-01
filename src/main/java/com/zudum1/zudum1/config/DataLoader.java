package com.zudum1.zudum1.config;

import com.zudum1.zudum1.model.Serie;
import com.zudum1.zudum1.model.Temporada;
import com.zudum1.zudum1.model.Episodio;
import com.zudum1.zudum1.repository.SerieRepository;
import com.zudum1.zudum1.repository.TemporadaRepository;
import com.zudum1.zudum1.repository.EpisodioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final SerieRepository serieRepository;
    private final TemporadaRepository temporadaRepository;
    private final EpisodioRepository episodioRepository;

    public DataLoader(SerieRepository serieRepository,
                      TemporadaRepository temporadaRepository,
                      EpisodioRepository episodioRepository) {
        this.serieRepository = serieRepository;
        this.temporadaRepository = temporadaRepository;
        this.episodioRepository = episodioRepository;
    }

    @Override
    public void run(String... args) {
        if (serieRepository.count() == 0) {
            cargarMidnightAtThePeraPalace();
            cargarTheCrown();
            cargarAliceInBorderland();
            cargarExtraordinaryAttorneyWoo();
            cargarBridgerton();
            cargarEmilyInParis();
            cargarCassandra();
            cargarStrangerThings();
            cargarDark();
        }
    }

    // Helpers reutilizables
    private Temporada crearTemporada(Serie serie, int numeroTemporada) {
        Temporada t = new Temporada();
        t.setSerie(serie);
        t.setNumeroTemporada(numeroTemporada);
        return temporadaRepository.save(t);
    }

    private void crearEpisodios(Temporada temporada, String[] titulos) {
        for (int i = 0; i < titulos.length; i++) {
            Episodio e = new Episodio();
            e.setTemporada(temporada);
            e.setNumeroEpisodio(i + 1);
            e.setTitulo(titulos[i]);
            episodioRepository.save(e);
        }
    }

    // 1. Midnight at the Pera Palace
    private void cargarMidnightAtThePeraPalace() {
        Serie s = new Serie();
        s.setTituloOriginal("Pera Palas'ta Gece Yarısı");
        s.setTituloLatam("Medianoche en el Pera Palace");
        s.setDescripcion("Serie turca de viajes en el tiempo ambientada en el icónico hotel Pera Palace.");
        s = serieRepository.save(s);

        // Season 1 (2022)
        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "The Journey",
                "Roots",
                "Secret",
                "Awol",
                "What Goes Around Comes Around",
                "Life or Death",
                "Confrontation",
                "Hairspring"
        });

        // Season 2 (2024)
        Temporada t2 = crearTemporada(s, 2);
        crearEpisodios(t2, new String[]{
                "Episode 1",
                "Episode 2",
                "Episode 3",
                "Episode 4",
                "Episode 5",
                "Episode 6",
                "Episode 7",
                "Episode 8"
        });
    }

    // 2. The Crown
    private void cargarTheCrown() {
        Serie s = new Serie();
        s.setTituloOriginal("The Crown");
        s.setTituloLatam("The Crown");
        s.setDescripcion("Drama histórico sobre el reinado de la Reina Isabel II.");
        s = serieRepository.save(s);

        // Season 1 (2016)
        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "Wolferton Splash",
                "Hyde Park Corner",
                "Windsor",
                "Act of God",
                "Smoke and Mirrors",
                "Gelignite",
                "Scientia Potentia Est",
                "Pride & Joy",
                "Assassins",
                "Gloria"
        });

        // Season 2 (2017)
        Temporada t2 = crearTemporada(s, 2);
        crearEpisodios(t2, new String[]{
                "Misadventure",
                "A Company of Men",
                "Lisbon",
                "Beryl",
                "Marionettes",
                "Vergangenheit",
                "Matrimonium",
                "Dear Mrs. Kennedy",
                "Paterfamilias",
                "Mystery Man"
        });

        // Season 3 (2019)
        Temporada t3 = crearTemporada(s, 3);
        crearEpisodios(t3, new String[]{
                "Olding",
                "Margaretology",
                "Aberfan",
                "Bubbikins",
                "Coup",
                "Tywysog Cymru",
                "Moondust",
                "Dangling Man",
                "Imbroglio",
                "Cri de Coeur"
        });

        // Season 4 (2020)
        Temporada t4 = crearTemporada(s, 4);
        crearEpisodios(t4, new String[]{
                "Gold Stick",
                "The Balmoral Test",
                "Fairytale",
                "Favourites",
                "Fagan",
                "Terra Nullius",
                "The Hereditary Principle",
                "48:1",
                "Avalanche",
                "War"
        });

        // Season 5 (2022)
        Temporada t5 = crearTemporada(s, 5);
        crearEpisodios(t5, new String[]{
                "Queen Victoria Syndrome",
                "The System",
                "Mou Mou",
                "Annus Horribilis",
                "The Way Ahead",
                "Ipatiev House",
                "No Woman's Land",
                "Gunpowder",
                "Couple 31",
                "Decommissioned"
        });

        // Season 6 (2023)
        Temporada t6 = crearTemporada(s, 6);
        crearEpisodios(t6, new String[]{
                "Persona Non Grata",
                "Two Photographs",
                "Dis-Moi Oui",
                "Aftermath"
        });
    }

    // 3. Alice in Borderland
    private void cargarAliceInBorderland() {
        Serie s = new Serie();
        s.setTituloOriginal("Imawa no Kuni no Arisu");
        s.setTituloLatam("Alice in Borderland");
        s.setDescripcion("Thriller japonés donde los participantes juegan a vida o muerte en un Tokio paralelo.");
        s = serieRepository.save(s);

        // Season 1 (2020)
        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "A Wonderful World",
                "The Beginning of Hell",
                "Gathering",
                "To Keep Living",
                "A Woman's Lie",
                "The Hunt",
                "A Risky Decision",
                "Everyone's Game"
        });

        // Season 2 (2022)
        Temporada t2 = crearTemporada(s, 2);
        crearEpisodios(t2, new String[]{
                "Tower Game",
                "Jack of Spades / Solitaire",
                "Quality Game",
                "Jack of Hearts",
                "Tower / Battle Game",
                "King of Clubs",
                "Queen of Hearts",
                "The Final Judgment"
        });

        // Season 3 (TBA)
        Temporada t3 = crearTemporada(s, 3);
        crearEpisodios(t3, new String[]{
                "Episode 1",
                "Episode 2",
                "Episode 3",
                "Episode 4",
                "Episode 5",
                "Episode 6"
        });
    }

    // 4. Extraordinary Attorney Woo
    private void cargarExtraordinaryAttorneyWoo() {
        Serie s = new Serie();
        s.setTituloOriginal("Iswan Byeonhosa Woo Yeong-woo");
        s.setTituloLatam("Woo, una abogada extraordinaria");
        s.setDescripcion("Drama coreano sobre una abogada en el espectro autista con un talento extraordinario.");
        s = serieRepository.save(s);

        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "The Humpback Whale",
                "The Strange Case of Woo Young-woo",
                "Hey! Whassup, I'm a Whale",
                "The Twenty-Year-Old Whale",
                "The Penguin of the Little Prince",
                "Between Blue Whales",
                "The Princess Bari and Oksu",
                "Boo! I'm a Dolphin!",
                "The Myth of the Whale",
                "Before and After the Killer Whale",
                "The Whale That Jumped Seven Times",
                "Whale vs. Whale",
                "The Whale and the Seagull",
                "The Reason the Whale Jumped",
                "The Sea of the Whale",
                "The Whale of the Plaza"
        });
    }

    // 5. Bridgerton
    private void cargarBridgerton() {
        Serie s = new Serie();
        s.setTituloOriginal("Bridgerton");
        s.setTituloLatam("Bridgerton");
        s.setDescripcion("Drama de época romántico producido por Shondaland.");
        s = serieRepository.save(s);

        // Season 1 (2020)
        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "Diamond of the First Water",
                "Shock and Delight",
                "Art of the Swoon",
                "An Affair of Honor",
                "The Duke and I",
                "Swish",
                "Oceans Apart",
                "After the Rain"
        });

        // Season 2 (2022)
        Temporada t2 = crearTemporada(s, 2);
        crearEpisodios(t2, new String[]{
                "Capital R Rake",
                "Off to the Races",
                "A Bee in Your Bonnet",
                "Victory",
                "An Unthinkable Fate",
                "The Choice",
                "Harmony",
                "The Viscount Who Loved Me"
        });

        // Season 3 (2024) Part 1 & Part 2
        Temporada t3 = crearTemporada(s, 3);
        crearEpisodios(t3, new String[]{
                "Out of the Shadows",
                "How Bright the Moon",
                "Forces of Nature",
                "Old Friends",
                "Tick Tock",
                "Romancing Mister Bridgerton",
                "Joining of Hands",
                "Into the Light"
        });
    }

    // 6. Emily in Paris
    private void cargarEmilyInParis() {
        Serie s = new Serie();
        s.setTituloOriginal("Emily in Paris");
        s.setTituloLatam("Emily en París");
        s.setDescripcion("Comedia romántica sobre una ejecutiva de marketing estadounidense en París.");
        s = serieRepository.save(s);

        // Season 1 (2020)
        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "Emily in Paris",
                "Masculin Féminin",
                "Sexy or Sexist",
                "A Kiss Is Just a Kiss",
                "Faux Amis",
                "An American Auction in Paris",
                "French Ending",
                "Family Affair",
                "An Englishman in Paris",
                "Cancel Couture"
        });

        // Season 2 (2021)
        Temporada t2 = crearTemporada(s, 2);
        crearEpisodios(t2, new String[]{
                "Voulez-Vous Coucher Avec Moi?",
                "Do You Know the Way to Saint-Germain?",
                "Bon Anniversaire!",
                "Jules and Em",
                "An Englishman in Paris",
                "Ex-en-Provence",
                "Oh là là Liste",
                "Fashion Victim",
                "Something in the Stairwell",
                "French Revolution"
        });

        // Season 3 (2022)
        Temporada t3 = crearTemporada(s, 3);
        crearEpisodios(t3, new String[]{
                "I Have Two Lovers",
                "What It Takes",
                "Coo D'état",
                "Live from the Hotel de Nonnes",
                "Ooo La La Liste",
                "Ex-en-trême",
                "How to Lose a Designer in 10 Days",
                "Fashion Week",
                "Love is in the Air",
                "Charade & Revelations"
        });
    }

    // 7. Cassandra
    private void cargarCassandra() {
        Serie s = new Serie();
        s.setTituloOriginal("Cassandra");
        s.setTituloLatam("Cassandra");
        s.setDescripcion("Serie de drama contemporáneo sobre una nueva etapa en la vida de Cassandra.");
        s = serieRepository.save(s);

        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "A Fresh Start",
                "Who Am I",
                "Endgame",
                "A Children's Game",
                "You Are Not Alone",
                "Merry Christmas"
        });
    }

    // 8. Stranger Things
    private void cargarStrangerThings() {
        Serie s = new Serie();
        s.setTituloOriginal("Stranger Things");
        s.setTituloLatam("Stranger Things");
        s.setDescripcion("Serie de ciencia ficción y terror ambientada en los años 80.");
        s = serieRepository.save(s);

        // Season 1 (2016)
        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "The Vanishing of Will Byers",
                "The Weirdo on Maple Street",
                "Holly, Jolly",
                "The Body",
                "The Flea and the Acrobat",
                "The Monster",
                "The Bathtub",
                "The Upside Down"
        });

        // Season 2 (2017)
        Temporada t2 = crearTemporada(s, 2);
        crearEpisodios(t2, new String[]{
                "MADMAX",
                "Trick or Treat, Freak",
                "The Pollywog",
                "Will the Wise",
                "Dig Dug",
                "The Spy",
                "The Lost Sister",
                "The Mind Flayer",
                "The Gate"
        });

        // Season 3 (2019)
        Temporada t3 = crearTemporada(s, 3);
        crearEpisodios(t3, new String[]{
                "Suzie, Do You Copy?",
                "The Mall Rats",
                "The Case of the Missing Lifeguard",
                "The Sauna Test",
                "The Flayed",
                "E Pluribus Unum",
                "The Bite",
                "The Battle of Starcourt"
        });

        // Season 4 (2022) Volume 1 & 2
        Temporada t4 = crearTemporada(s, 4);
        crearEpisodios(t4, new String[]{
                "The Hellfire Club",
                "Vecna's Curse",
                "The Monster and the Superhero",
                "Dear Billy",
                "The Nina Project",
                "The Dive",
                "The Massacre at Hawkins Lab",
                "Papa",
                "The Piggyback"
        });
    }

    // 9. Dark
    private void cargarDark() {
        Serie s = new Serie();
        s.setTituloOriginal("Dark");
        s.setTituloLatam("Dark");
        s.setDescripcion("Thriller de ciencia ficción y viajes en el tiempo ambientado en el pueblo de Winden.");
        s = serieRepository.save(s);

        // Season 1 (2017)
        Temporada t1 = crearTemporada(s, 1);
        crearEpisodios(t1, new String[]{
                "Secrets",
                "Lies",
                "Past and Present",
                "Double Lives",
                "Truths",
                "Sic Mundus Creatus Est",
                "Crossroads",
                "As You Sow, so You Shall Reap",
                "Everything Is Now",
                "Alpha and Omega"
        });

        // Season 2 (2019)
        Temporada t2 = crearTemporada(s, 2);
        crearEpisodios(t2, new String[]{
                "Beginnings and Endings",
                "Dark Matter",
                "Ghosts",
                "The Travelers",
                "Lost and Found",
                "An Endless Cycle",
                "The White Devil",
                "Endings and Beginnings"
        });

        // Season 3 (2020)
        Temporada t3 = crearTemporada(s, 3);
        crearEpisodios(t3, new String[]{
                "Deja-vu",
                "The Survivors",
                "Adam and Eva",
                "The Origin",
                "Life and Death",
                "Light and Shadow",
                "Between the Time",
                "The Paradise"
        });
    }
}
