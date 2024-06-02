package com.example.kingslibrary.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kingslibrary.Fragment.SearchFragment;
import com.example.kingslibrary.R;
import com.squareup.picasso.Picasso;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BookDetailsActivity extends AppCompatActivity {

    private ImageView bookDetailImg, backDetails;
    private TextView bookDetailTitle, bookDetailPublisher, bookDetailYear, bookDetailISBN, bookDetailPages, bookDetailSynopsis;
    private TextView readMore;
    private LinearLayout linearDetails;
    private ProgressBar loadDetails;
    Handler handler = new Handler(Looper.getMainLooper());
    Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        loadDetails = findViewById(R.id.loadDetails);
        linearDetails = findViewById(R.id.linearDetails);
        bookDetailImg = findViewById(R.id.bookDetailImg);
        bookDetailTitle = findViewById(R.id.bookDetailTitle);
        bookDetailPublisher = findViewById(R.id.bookDetailPublisher);
        bookDetailYear = findViewById(R.id.bookDetailYear);
        bookDetailISBN = findViewById(R.id.bookDetailISBN);
        bookDetailPages = findViewById(R.id.bookDetailPages);
        bookDetailSynopsis = findViewById(R.id.bookDetailSynopsis);
        readMore = findViewById(R.id.readMore);
        backDetails = findViewById(R.id.backDetails);

        Intent intent = getIntent();
        String thisTitle = intent.getStringExtra("title");
        String thisPublisher = intent.getStringExtra("publisher");
        Integer thisYear = intent.getIntExtra("year", -1);
        String thisISBN = intent.getStringExtra("isbn");
        Integer thisPages = intent.getIntExtra("pages", -1);
        Integer thisID = intent.getIntExtra("id", -1);

        bookDetailTitle.setText(thisTitle);
        bookDetailPublisher.setText(thisPublisher);
        bookDetailYear.setText(String.valueOf(thisYear));
        bookDetailISBN.setText(thisISBN);
        bookDetailPages.setText(String.valueOf(thisPages));

        linearDetails.setVisibility(View.GONE);
        loadDetails.setVisibility(View.VISIBLE);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        linearDetails.setVisibility(View.VISIBLE);
                        loadDetails.setVisibility(View.GONE);
                    }
                });
            }
        });

        if (thisID != -1) {
            switch (thisID) {
                case 1:
                    Picasso.get().load(R.drawable.carrie).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("Carrie is Stephen King's debut novel that tells the story of Carrie White, a high school girl with telekinetic powers who faces severe bullying and abuse from her peers and her religiously fanatic mother. When Carrie is pushed too far on prom night, she unleashes her powers in a devastating and deadly act of revenge. This chilling tale explores themes of power, revenge, and the supernatural.");
                    break;
                case 2:
                    Picasso.get().load(R.drawable.salems_lot).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In Salem's Lot, author Ben Mears returns to the town of Jerusalem's Lot (Salem's Lot) to write a book, only to discover that the residents are becoming vampires. As the vampire plague spreads, Mears and a small group of allies must confront the ancient evil behind it. This novel is a chilling exploration of horror, evil, and the battle between good and malevolent forces.");
                    break;
                case 3:
                    Picasso.get().load(R.drawable.the_shining).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("The Shining follows Jack Torrance, an aspiring writer and recovering alcoholic who takes a job as the winter caretaker of the Overlook Hotel, isolated in the Colorado Rockies. Jack brings his wife Wendy and son Danny, who possesses psychic abilities known as \"the shining.\" As the hotel's supernatural forces awaken, Jack descends into madness, putting his family in grave danger. This story is a masterful blend of psychological horror and the supernatural.");
                    break;
                case 4:
                    Picasso.get().load(R.drawable.rage).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("Published under the pseudonym Richard Bachman, Rage tells the story of Charlie Decker, a high school student who brings a gun to school, kills two teachers, and holds his class hostage. As the tense standoff unfolds, Charlie manipulates and terrorizes his classmates, revealing deep-seated issues and dark secrets. The novel explores themes of violence, mental illness, and societal pressure.");
                    break;
                case 5:
                    Picasso.get().load(R.drawable.the_stand).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("The Stand is an epic apocalyptic tale where a weaponized strain of influenza wipes out 99% of the world's population. The survivors split into two factions: one led by the benevolent Mother Abagail and the other by the malevolent Randall Flagg. As the two groups prepare for a final confrontation, themes of good versus evil, survival, and the rebuilding of society are explored in depth.");
                    break;
                case 6:
                    Picasso.get().load(R.drawable.the_long_walk).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("Also published under the pseudonym Richard Bachman, The Long Walk follows 100 teenage boys who participate in an annual walking contest where they must maintain a speed of four miles per hour without stopping. The last boy standing wins a grand prize, but the cost of failure is death. This dystopian novel examines themes of endurance, human nature, and the societal obsession with competition.");
                    break;
                case 7:
                    Picasso.get().load(R.drawable.the_dead_zone).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("The Dead Zone centers on Johnny Smith, who awakens from a five-year coma with the ability to see the past and future through touch. As Johnny struggles to come to terms with his new abilities, he becomes entangled in a series of events that lead him to a critical decision: whether to use his powers to stop a rising political figure who poses a grave threat to humanity. This novel blends supernatural elements with political and ethical dilemmas.");
                    break;
                case 8:
                    Picasso.get().load(R.drawable.firestarter).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In Firestarter, young Charlie McGee has the ability to start fires with her mind, a power inherited from her parents who were part of a government experiment. As Charlie and her father are pursued by a secret government agency, they must evade capture and control her dangerous abilities. This thrilling tale explores themes of power, control, and the consequences of scientific experimentation.");
                    break;
                case 9:
                    Picasso.get().load(R.drawable.roadwork).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("Published under the pseudonym Richard Bachman, Roadwork follows Barton Dawes, a man who takes a stand against the demolition of his home and workplace to make way for a new highway. As he spirals into despair and resistance, Dawes' fight against the inevitable leads to a tragic and explosive conclusion. This novel delves into themes of loss, defiance, and the impact of progress on individual lives.");
                    break;
                case 10:
                    Picasso.get().load(R.drawable.cujo).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("Cujo tells the harrowing story of a rabid St. Bernard who terrorizes a small town. Donna Trenton and her young son Tad are trapped in their car by the monstrous dog, leading to a desperate struggle for survival. This intense narrative explores themes of fear, isolation, and the randomness of fate, all set against the backdrop of a quiet community turned nightmarish.");
                    break;
                case 11:
                    Picasso.get().load(R.drawable.the_running_man).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("Set in a dystopian future, \"The Running Man\" follows Ben Richards, a desperate man who enters a deadly reality TV game show to earn money for his family. The show pits him against professional killers known as \"The Gladiators,\" led by the ruthless host, Damon Killian. As Richards fights for survival, he exposes the corrupt and brutal nature of the society that created such a game.");
                    break;
                case 12:
                    Picasso.get().load(R.drawable.the_dark_tower_1).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Dark Tower: The Gunslinger\" is the first installment in Stephen King's epic Dark Tower series. It follows Roland Deschain, the last gunslinger, as he pursues the enigmatic Man in Black across a vast desert. Along the way, Roland encounters various characters and faces many challenges, all while seeking to unravel the mysteries of the Dark Tower, the linchpin of all universes.");
                    break;
                case 13:
                    Picasso.get().load(R.drawable.christine).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Christine\" tells the story of a 1958 Plymouth Fury possessed by a malevolent force. The car, named Christine, gradually takes control of its new owner, teenager Arnie Cunningham. As Arnie becomes increasingly obsessed with Christine, his personality changes and dark events unfold, leading to deadly consequences for anyone who threatens the car.");
                    break;
                case 14:
                    Picasso.get().load(R.drawable.pet_semetary).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Pet Sematary\" centers on the Creed family, who move to a rural home near an ancient burial ground with dark powers. When tragedy strikes and their young son Gage is killed, the grief-stricken father, Louis Creed, buries him in the cursed ground, hoping to bring him back to life. However, the resurrected Gage returns as something evil, leading to horrifying consequences.");
                    break;
                case 15:
                    Picasso.get().load(R.drawable.cycle_of_the_werewolf).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Cycle of the Werewolf\" is a horror novella that unfolds over the course of a year in the small town of Tarker's Mills. Each month brings a new full moon, and with it, brutal attacks by a werewolf. As the townspeople become more desperate, a young boy named Marty Coslaw, confined to a wheelchair, takes it upon himself to uncover the beast's identity and put an end to the terror.");
                    break;
                case 16:
                    Picasso.get().load(R.drawable.the_talisman).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In \"The Talisman,\" young Jack Sawyer embarks on a quest across America and a parallel world known as the Territories to find a mystical talisman that can save his dying mother. Along his journey, Jack faces various dangers and encounters allies and enemies alike. This epic adventure explores themes of courage, loyalty, and the battle between good and evil.");
                    break;
                case 17:
                    Picasso.get().load(R.drawable.the_eyes_of_the_dragon).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("Set in the kingdom of Delain, \"The Eyes of the Dragon\" follows the story of two royal brothers, Peter and Thomas. When their father, King Roland, is murdered by the dark magician Randall Flagg, Peter is wrongfully imprisoned for the crime. With the kingdom in Flagg's sinister grip, Peter must use his cunning and bravery to escape and reclaim his throne, while Thomas wrestles with his own role in the tragedy.");
                    break;
                case 18:
                    Picasso.get().load(R.drawable.thinner).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Thinner\" tells the story of Billy Halleck, an overweight lawyer who is cursed by a gypsy after accidentally running over her daughter. As the curse takes hold, Billy begins to lose weight at an alarming rate, with no end in sight. Desperate to break the curse and save his life, Billy seeks out the gypsy who cursed him, leading to a harrowing confrontation.");
                    break;
                case 19:
                    Picasso.get().load(R.drawable.it).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"It\" follows a group of friends, known as the Losers' Club, as they confront a shape-shifting entity that takes the form of a clown named Pennywise. The creature preys on the children of Derry, Maine, every 27 years. The narrative alternates between the characters' childhood in the 1950s and their return to Derry as adults in the 1980s, as they face their deepest fears to defeat Pennywise once and for all.");
                    break;
                case 20:
                    Picasso.get().load(R.drawable.the_dark_tower_2).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In \"The Dark Tower II: The Drawing of the Three,\" Roland Deschain continues his quest for the Dark Tower. After being attacked by monstrous lobstrosities, he must \"draw\" three companions from different times and places to aid him: Eddie Dean, a heroin addict; Odetta Holmes/Detta Walker, a woman with dual personalities; and Jack Mort, a sociopathic killer. Together, they must navigate challenges and form an unlikely fellowship.\n" + "\n");
                    break;
                case 21:
                    Picasso.get().load(R.drawable.misery).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Misery\" tells the harrowing story of Paul Sheldon, a famous author who is kidnapped by his self-proclaimed \"number one fan,\" Annie Wilkes, after a car accident. When Annie discovers that Paul has killed off her favorite character in his latest novel, she forces him to write a new story under her terrifying and sadistic supervision. Paul's fight for survival becomes a desperate battle of wits against his unhinged captor.");
                    break;
                case 22:
                    Picasso.get().load(R.drawable.the_tommyknockers).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In \"The Tommyknockers,\" writer Bobbi Anderson discovers a mysterious metal object buried in the woods near her home in Haven, Maine. As she excavates it, strange occurrences and transformations begin to affect the townspeople, turning them into \"Tommyknockers.\" Bobbi and her friend, Jim Gardener, must uncover the truth behind the artifact and its alien influence before it consumes them all.");
                    break;
                case 23:
                    Picasso.get().load(R.drawable.the_dark_half).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Dark Half\" follows author Thad Beaumont, who writes under the pseudonym George Stark. When Thad decides to kill off his alter ego, George Stark comes to life, determined to exact revenge. As bodies begin to pile up, Thad must confront his dark half and uncover the secrets of his own psyche to stop the murderous rampage.\n" + "\n");
                    break;
                case 24:
                    Picasso.get().load(R.drawable.the_stand_uncut).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In this expanded edition of \"The Stand,\" Stephen King presents the complete and uncut version of his apocalyptic epic. After a man-made plague decimates the world's population, the survivors are drawn into a battle between good and evil. The story follows various characters as they navigate the chaotic aftermath, ultimately converging in a final showdown between the forces led by the benevolent Mother Abagail and the malevolent Randall Flagg.");
                    break;
                case 25:
                    Picasso.get().load(R.drawable.the_dark_tower_3).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Dark Tower III: The Waste Lands\" continues Roland Deschain's quest for the Dark Tower. Along with his companions Eddie Dean and Susannah Dean, Roland ventures into the desolate landscape known as the Waste Lands. They face numerous challenges, including the psychotic train Blaine the Mono and the ever-looming threat of Randall Flagg. The journey tests their courage and unity as they strive to reach the elusive Dark Tower.");
                    break;
                case 26:
                    Picasso.get().load(R.drawable.needful_things).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Needful Things\" tells the story of a new shop opening in the small town of Castle Rock, Maine. The shop, run by the enigmatic Leland Gaunt, offers items that seem to fulfill the deepest desires of the townspeople. However, each purchase comes with a dark price, leading to chaos and violence. As the town descends into madness, a few residents must uncover Gaunt's true intentions and stop him before it's too late.");
                    break;
                case 27:
                    Picasso.get().load(R.drawable.geralds_game).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In \"Gerald's Game,\" a seemingly innocuous bondage game between a married couple goes horribly wrong when Gerald Burlingame dies of a heart attack, leaving his wife Jessie handcuffed to the bed in a remote cabin. Alone and struggling to survive, Jessie faces her inner demons and the haunting presence of a mysterious figure. The novel delves into themes of trauma, survival, and resilience.");
                    break;
                case 28:
                    Picasso.get().load(R.drawable.dolores_claiborne).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Dolores Claiborne\" is a psychological thriller that explores the life of a tough, no-nonsense woman accused of murdering her wealthy employer, Vera Donovan. Through a gripping monologue, Dolores recounts her troubled marriage to the abusive Joe St. George, the mysterious circumstances of his death, and her complex relationship with Vera. The novel delves into themes of abuse, justice, and redemption.\n" + "\n");
                    break;
                case 29:
                    Picasso.get().load(R.drawable.insomnia).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Insomnia\" follows Ralph Roberts, a widower who begins suffering from chronic insomnia. As his sleeplessness progresses, Ralph starts seeing strange auras around people and witnessing supernatural events. He discovers that his condition allows him to see into other dimensions and that he has a crucial role in a cosmic battle involving the Crimson King. Ralph must use his newfound abilities to prevent a catastrophic event.");
                    break;
                case 30:
                    Picasso.get().load(R.drawable.rose_madder).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Rose Madder\" centers on Rosie Daniels, who escapes her abusive husband, Norman, after fourteen years of marriage. Starting a new life, Rosie discovers an extraordinary painting that allows her to enter a surreal world. As she gains strength and independence, Norman, a relentless and sadistic cop, tracks her down. The novel intertwines themes of empowerment and the supernatural as Rosie fights for her freedom and sanity.");
                    break;
                case 31:
                    Picasso.get().load(R.drawable.the_green_mile).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Green Mile\" is set in the 1930s on Death Row at Cold Mountain Penitentiary. The story is narrated by Paul Edgecombe, the block supervisor, and follows the arrival of John Coffey, a giant of a man with a childlike demeanor who is convicted of murdering two young girls. As supernatural events unfold, Paul realizes that Coffey possesses miraculous healing powers. The novel explores themes of justice, humanity, and redemption.");
                    break;
                case 32:
                    Picasso.get().load(R.drawable.desperation).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In \"Desperation,\" travelers on a desolate Nevada highway are abducted by Collie Entragian, the sheriff of the deserted mining town of Desperation. As they uncover the horrifying truth about the town and the ancient evil that possesses Entragian, the survivors must band together to fight the malevolent force known as Tak. The novel delves into themes of survival, faith, and the battle between good and evil.");
                    break;
                case 33:
                    Picasso.get().load(R.drawable.the_regulators).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Regulators\" takes place in a seemingly normal suburban neighborhood that is transformed into a nightmare when a malevolent force named Tak begins manipulating reality. The residents are trapped in a surreal and deadly game orchestrated by a young boy, Seth Garin, who is possessed by Tak. The novel explores themes of power, reality, and the human spirit's resilience in the face of overwhelming evil.");
                    break;
                case 34:
                    Picasso.get().load(R.drawable.the_dark_tower_4).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Wizard and Glass\" continues Roland Deschain's quest for the Dark Tower. After narrowly escaping the malevolent Blaine the Mono, Roland and his ka-tet find themselves in the world of the past. Roland recounts a haunting story from his youth, involving his doomed love, Susan Delgado, and the treacherous intrigues of the Barony of Mejis. This tale sheds light on Roland's motivations and the sacrifices made in his relentless pursuit of the Dark Tower.");
                    break;
                case 35:
                    Picasso.get().load(R.drawable.bag_of_bones).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Bag of Bones\" follows bestselling author Mike Noonan, who retreats to his summer home in rural Maine after the sudden death of his wife, Jo. Haunted by nightmares and ghostly visitations, Mike becomes entangled in the decades-old mystery of Sara Tidwell, a blues singer whose vengeful spirit torments the town. As he uncovers secrets buried in the past, Mike must confront his own grief and the supernatural forces threatening his future.");
                    break;
                case 36:
                    Picasso.get().load(R.drawable.the_girl_who_loved_tom_gorgon).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In \"The Girl Who Loved Tom Gordon,\" nine-year-old Trisha McFarland becomes lost in the dense woods of New England after wandering off the trail during a family hike. As she struggles to survive, Trisha draws strength from her admiration for her baseball hero, Tom Gordon. Facing hunger, thirst, and the terror of being stalked by an unseen predator, Trisha's journey becomes a battle of wits and willpower against the wilderness.");
                    break;
                case 37:
                    Picasso.get().load(R.drawable.dreamcatcher).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Dreamcatcher\" tells the story of four lifelong friends who reunite for a hunting trip in the remote woods of Maine. Their vacation is disrupted by a mysterious and deadly extraterrestrial presence, leading to a harrowing struggle for survival. The friends must confront their past and the alien entity threatening their lives, relying on their bond and the extraordinary abilities of one of their own to fight back.");
                    break;
                case 38:
                    Picasso.get().load(R.drawable.black_house).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("In \"Black House,\" retired homicide detective Jack Sawyer is drawn back into a world of darkness when a series of brutal murders occur in the small town of French Landing, Wisconsin. Written with Peter Straub, this sequel to \"The Talisman\" sees Jack confronting the malevolent forces linked to the Crimson King. As Jack uncovers the connection between the murders and a parallel universe, he must use his unique abilities to save both worlds.\n" + "\n");
                    break;
                case 39:
                    Picasso.get().load(R.drawable.from_a_buick_8).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"From a Buick 8\" revolves around a mysterious vintage car stored in the barracks of Troop D of the Pennsylvania State Police. After the car's owner disappears, the troopers discover that the Buick is a portal to another dimension. The story unfolds through the memories of the troopers as they recount their strange and often terrifying encounters with the car, exploring themes of curiosity, fear, and the unknown.");
                    break;
                case 40:
                    Picasso.get().load(R.drawable.the_dark_tower_5).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Wolves of the Calla\" continues the journey of Roland Deschain and his ka-tet toward the Dark Tower. The group arrives in the town of Calla Bryn Sturgis, where they learn of the townspeople's plight: their children are being kidnapped by mysterious wolves and returned with severe mental impairments. Roland and his companions agree to help the villagers, leading to a tense and epic confrontation with the wolves.");
                    break;
                case 41:
                    Picasso.get().load(R.drawable.the_dark_tower_6).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Song of Susannah\" focuses on Susannah Dean, who is possessed by the entity Mia and transported to New York City in 1999. Roland and Eddie follow her trail, encountering danger and revelations about the nature of their quest. As Susannah struggles with Mia's control and the impending birth of a powerful being, the ka-tet faces critical choices that will determine the fate of their journey to the Dark Tower.");
                    break;
                case 42:
                    Picasso.get().load(R.drawable.the_dark_tower_7).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Dark Tower\" concludes the epic journey of Roland Deschain and his ka-tet. As they near the Dark Tower, they face their greatest challenges, including the final confrontation with the Crimson King and other formidable enemies. Roland's relentless pursuit of the Tower leads to profound sacrifices and revelations, culminating in an ending that underscores the cyclical nature of his quest and the true meaning of destiny.");
                    break;
                case 43:
                    Picasso.get().load(R.drawable.the_colorado_kid).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Colorado Kid\" is a mystery novel set on Moose-Lookit Island, Maine, where two veteran newspapermen recount the tale of an unidentified man found dead on the beach. The story, told to a young intern, delves into the enigmatic circumstances surrounding the man's death and the elusive clues that hint at his identity. The novel explores themes of mystery, the limits of journalism, and the nature of unsolved cases.");
                    break;
                case 44:
                    Picasso.get().load(R.drawable.cell).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Cell\" follows artist Clayton Riddell as a mysterious signal broadcast over the global cell phone network turns the majority of humans into mindless, violent \"phoners.\" Amidst the chaos, Clay joins forces with a small group of survivors to navigate the post-apocalyptic landscape and search for his young son. The group faces numerous dangers, including the sinister leader of the phoners, known as the Raggedy Man.");
                    break;
                case 45:
                    Picasso.get().load(R.drawable.liseys_story).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Lisey's Story\" explores the life of Lisey Landon, widow of a famous novelist, Scott Landon. After Scott's death, Lisey begins to uncover hidden memories and secrets about her husband's life and his ability to access a supernatural realm called Boo'ya Moon. As she confronts her own past traumas and the dark forces tied to Scott's legacy, Lisey must protect herself from a dangerous stalker and find strength in her late husband's love.\n" + "\n");
                    break;
                case 46:
                    Picasso.get().load(R.drawable.blaze ).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Blaze\" is the tragic story of Clayton \"Blaze\" Blaisdell, a mentally impaired con artist. Written under Stephen King's pseudonym Richard Bachman, the novel follows Blaze's scheme to kidnap a wealthy couple's baby for ransom. As he struggles with his criminal plans and memories of his abusive past, Blaze's conscience is haunted by the ghostly presence of his former partner in crime, George Rackley.");
                    break;
                case 47:
                    Picasso.get().load(R.drawable.duma_key).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Duma Key\" tells the story of Edgar Freemantle, who relocates to the remote island of Duma Key, Florida, after a near-fatal construction accident. As he recovers and begins to paint, Edgar discovers his artwork has supernatural properties, revealing dark secrets and malevolent forces linked to the island's history. Edgar must confront these powers to save himself and those he loves.");
                    break;
                case 48:
                    Picasso.get().load(R.drawable.under_the_dome).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Under the Dome\" depicts the sudden appearance of an impenetrable dome over the small town of Chester's Mill, Maine. Cut off from the outside world, the town descends into chaos. As resources dwindle and tensions rise, a group of townspeople, led by Iraq War veteran Dale \"Barbie\" Barbara, struggle against the authoritarian rule of Big Jim Rennie and uncover the dome's mysterious origins.");
                    break;
                case 49:
                    Picasso.get().load(R.drawable.one_two_six).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"11/22/63\" follows high school teacher Jake Epping, who discovers a time portal that leads to 1958. Urged by his dying friend Al, Jake takes on the mission to prevent the assassination of President John F. Kennedy. As he navigates the past, Jake builds a new life, faces unforeseen challenges, and grapples with the moral complexities of altering history.");
                    break;
                case 50:
                    Picasso.get().load(R.drawable.the_dark_tower_8).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Wind Through the Keyhole\" is a standalone novel set within the Dark Tower series. Chronologically placed between the fourth and fifth volumes, the book features Roland Deschain and his ka-tet taking shelter from a storm. Roland narrates two interwoven stories: one from his youth involving a deadly shape-shifter, and another a fantastical tale of a young boy's quest for justice.");
                    break;
                case 51:
                    Picasso.get().load(R.drawable.joyland).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Joyland\" centers on college student Devin Jones, who takes a summer job at a North Carolina amusement park. He becomes entangled in the mystery of a young girl's murder that occurred years earlier. As Devin uncovers clues about the killer's identity, he also deals with heartbreak and forms life-changing friendships, all while discovering the park's ghostly secrets.");
                    break;
                case 52:
                    Picasso.get().load(R.drawable.doctor_sleep).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Doctor Sleep\" is the sequel to \"The Shining,\" following an adult Dan Torrance as he struggles with his traumatic past and alcoholism. Dan's psychic abilities reawaken when he forms a connection with a young girl named Abra, who possesses extraordinary powers. Together, they face the True Knot, a group of quasi-immortal beings led by Rose the Hat, who feed on the psychic essence of children.\n" + "\n");
                    break;
                case 53:
                    Picasso.get().load(R.drawable.mr_mercedes).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Mr. Mercedes\" is a gripping thriller that introduces retired detective Bill Hodges. He is drawn back into the investigative world by a taunting letter from Brady Hartsfield, the perpetrator of a deadly vehicular massacre. As Hodges teams up with unlikely allies to stop Hartsfield's plans for another horrific act, a deadly game of cat and mouse ensues.");
                    break;
                case 54:
                    Picasso.get().load(R.drawable.revival).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Revival\" follows the lives of Jamie Morton and Reverend Charles Jacobs, whose paths cross multiple times over the decades. Jacobs, obsessed with experimenting on electricity's miraculous and horrific powers after the tragic loss of his family, draws Jamie into his dangerous quest. The story explores themes of faith, addiction, and the terrifying consequences of tampering with the unknown, culminating in a chilling revelation involving the enigmatic entity known as the Mother of the Null.");
                    break;
                case 55:
                    Picasso.get().load(R.drawable.finders_keepers).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Finders Keepers\" is the second novel in the Bill Hodges Trilogy. It centers on Morris Bellamy, an obsessive reader who murders his favorite author, John Rothstein, and steals notebooks containing unpublished work. Decades later, young Pete Saubers discovers the stolen cash and notebooks. When Morris is released from prison, he will stop at nothing to retrieve his treasure. Retired detective Bill Hodges must protect Pete and his family from Morris's deadly obsession.");
                    break;
                case 56:
                    Picasso.get().load(R.drawable.end_of_watch).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"End of Watch\" concludes the Bill Hodges Trilogy, where retired detective Bill Hodges faces his old nemesis, Brady Hartsfield, also known as Mr. Mercedes. Despite being left in a vegetative state, Brady has developed new psychic abilities and plans a final, catastrophic act of terror. Bill, along with his partner Holly Gibney, must thwart Brady's mind-control scheme before it causes mass suicide and chaos.");
                    break;
                case 57:
                    Picasso.get().load(R.drawable.gwendys_button_box).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Gwendy's Button Box,\" co-written with Richard Chizmar, tells the story of twelve-year-old Gwendy Peterson, who receives a mysterious box from a stranger named Richard Farris. The box has buttons that grant both wonders and catastrophes, depending on how they are used. As Gwendy grows up, she grapples with the box's power and the moral dilemmas it presents, shaping her life in unexpected ways.");
                    break;
                case 58:
                    Picasso.get().load(R.drawable.sleeping_beauties).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Sleeping Beauties,\" co-written with Owen King, explores a world where women succumb to a strange, sleeping disease, becoming cocooned and unreachable. As they sleep, society crumbles, leaving the men to fend for themselves. The story focuses on the small town of Dooling and the mysterious woman, Evie Black, who appears to be immune. Conflicts arise over whether to study, protect, or destroy Evie, who might hold the key to saving humanity.");
                    break;
                case 59:
                    Picasso.get().load(R.drawable.the_outsider).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Outsider\" follows detective Ralph Anderson as he investigates the brutal murder of a young boy. All evidence points to beloved teacher Terry Maitland, but when conflicting evidence surfaces, Ralph uncovers a more sinister force at work. The case leads to the discovery of a supernatural creature that can shape-shift and is responsible for a series of similar crimes. Holly Gibney joins Ralph in the pursuit of this malevolent entity.");
                    break;
                case 60:
                    Picasso.get().load(R.drawable.elevation).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Elevation\" tells the story of Scott Carey, a man experiencing a mysterious condition where he loses weight without any physical changes. As he grapples with his inexplicable weight loss, Scott strives to improve the lives of those around him, including his neighbors, a lesbian couple facing prejudice in their small town. The novella explores themes of community, acceptance, and the human spirit's resilience.");
                    break;
                case 61:
                    Picasso.get().load(R.drawable.the_institute).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"The Institute\" follows the harrowing experiences of Luke Ellis, a gifted child abducted and taken to a facility called the Institute. There, children with extraordinary abilities are subjected to brutal experiments. Luke bonds with other captives as they plot an escape. Meanwhile, ex-cop Tim Jamieson stumbles upon the Institute and becomes an unlikely hero in the quest to expose its dark secrets and rescue the children.");
                    break;
                case 62:
                    Picasso.get().load(R.drawable.later).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Later\" is a supernatural thriller about Jamie Conklin, a boy who can see and communicate with the dead. His gift becomes a burden when his mother, a literary agent, and a corrupt cop exploit his abilities to solve crimes and gain wealth. As Jamie grows up, he must navigate the moral complexities of his power and confront a malevolent spirit that poses a grave threat to his life.");
                    break;
                case 63:
                    Picasso.get().load(R.drawable.billy_summers).resize(200, 300).into(bookDetailImg);
                    bookDetailSynopsis.setText("\"Billy Summers\" follows the titular character, a hitman with a moral code who only kills bad people. Planning to retire, Billy takes one last job, posing as a writer to get close to his target. As he waits for the perfect moment, Billy starts writing his own story, revealing his traumatic past. When the job goes wrong, Billy is forced into a deadly game of cat and mouse, seeking revenge and redemption.");
                    break;
            }
        }

        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readMore.getText().equals("Read More")) {
                    bookDetailSynopsis.setMaxLines(Integer.MAX_VALUE);
                    readMore.setText("Read Less");
                } else {
                    bookDetailSynopsis.setMaxLines(4);
                    readMore.setText("Read More");
                }
            }
        });

        backDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}