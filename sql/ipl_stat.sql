create table team_details(
	team varchar(4) primary key,
	name varchar(250) not null,
	captain varchar(250) not null
);

INSERT INTO team_details(name,team,captain) VALUES
 ('Gujarat Titans','GT','Hardik Pandya'),
 ('Delhi Capitals','DC','Rishabh Pant'),
 ('Chennai Super Kings','CSK','Ravindra Jadeja'),
 ('Kolkata Knight Riders','KKR','Shreyas Iyer'),
 ('Lucknow Super Giants','LSG','KL Rahul'),
 ('Mumbai Indians','MI','Rohit Sharma'),
 ('Punjab Kings','PBKS','Mayank Agarwal'),
 ('Rajasthan Royals','RR','Sanju Samson'),
 ('Royal Challengers Bangalore','RCB','Faf du Plessis'),
 ('Sunrisers Hyderabad','SRH','Kane Williamson');

select * from team_details td;

drop table player;

CREATE TABLE IF NOT EXISTS player(
   id serial primary key,
   name    VARCHAR(22) not NULL
  ,role    VARCHAR(11) NOT NULL
  ,amount  INTEGER  NOT NULL
  ,country VARCHAR(12) NOT NULL
  ,team    VARCHAR(4)
);

ALTER SEQUENCE player_id_seq RESTART WITH 1000;

INSERT INTO player(name,role,amount,country,team) VALUES
 ('Sam Curran','All-rounder',185000000,'England','PBKS')
,('Cameron Green','All-rounder',185000000,'Australia','MI')
,('KL Rahul','WK-Batsman',170000000,'India','LSG')
,('Ben Stokes','All-rounder',162500000,'England','CSK')
,('Ravindra Jadeja','All-rounder',160000000,'India','CSK')
,('Rishabh Pant','WT-Batsman',160000000,'India','DC')
,('Nicholas Pooran','WK-Batsman',160000000,'West Indies','LSG')
,('Rohit Sharma','Batsman',160000000,'India','MI')
,('Ishan Kishan','WK-Batsman',152500000,'India','MI')
,('Rashid Khan','Bowler',150000000,'Afghanistan','GT')
,('Hardik Pandya','All-rounder',150000000,'India','GT')
,('Virat Kohli','Batsman',150000000,'India','RCB')
,('Deepak Chahar','Bowler',140000000,'India','CSK')
,('Sanju Samson','WK-Batsman',140000000,'India','RR')
,('Harry Brook','Batsman',132500000,'England','SRH')
,('Shreyas Iyer','Batsman',122500000,'India','KKR')
,('MS Dhoni','WK-Batsman',120000000,'India','CSK')
,('Andre Russell','All-rounder',120000000,'West Indies','KKR')
,('Jasprit Bumrah','Bowler',120000000,'India','MI')
,('Liam Livingstone','All-rounder',115000000,'England','PBKS')
,('Glenn Maxwell','All-rounder',110000000,'Australia','RCB')
,('Shardul Thakur','Bowler',107500000,'India','KKR')
,('Harshal Patel','Bowler',107500000,'India','RCB')
,('Wanindu Hasaranga','All-rounder',107500000,'Sri Lanka','RCB')
,('Lockie Ferguson','Bowler',100000000,'New Zealand','KKR')
,('Avesh Khan','Bowler',100000000,'India','LSG')
,('Jos Buttler','WK-Batsman',100000000,'England','RR')
,('Prasidh Krishna','Bowler',100000000,'India','RR')
,('Kagiso Rabada','Bowler',92500000,'South Africa','PBKS')
,('Marcus Stoinis','All-rounder',92000000,'Australia','LSG')
,('Axar Patel','All-rounder',90000000,'India','DC')
,('Rahul Tewatia','All-rounder',90000000,'India','GT')
,('Shahrukh Khan','Batsman',90000000,'India','PBKS')
,('Washington Sundar','All-rounder',87500000,'India','SRH')
,('Shimron Hetmyer','Batsman',85000000,'West Indies','RR')
,('Rahul Tripathi','Batsman',85000000,'India','SRH')
,('Krunal Pandya','All-rounder',82500000,'India','LSG')
,('Tim David','All-rounder',82500000,'Singapore','MI')
,('Mayank Agarwal','Batsman',82500000,'India','SRH')
,('Shikhar Dhawan','Batsman',82500000,'India','PBKS')
,('Moeen Ali','All-rounder',80000000,'England','CSK')
,('Shubman Gill','Batsman',80000000,'India','GT')
,('Nitish Rana','Batsman',80000000,'India','KKR')
,('Varun Chakravarty','Bowlers',80000000,'India','KKR')
,('Venkatesh Iyer','All-rounder',80000000,'India','KKR')
,('Suryakumar Yadav','Batsman',80000000,'India','MI')
,('Jofra Archer','Bowler',80000000,'England','MI')
,('Trent Boult','Bowler',80000000,'New Zealand','RR')
,('Devdutt Padikkal','Batsman',77500000,'India','RR')
,('Josh Hazlewood','Bowler',77500000,'Australia','RCB')
,('Prithvi Shaw','Batsman',75000000,'India','DC')
,('Faf du Plessis','Batsman',70000000,'South Africa','RCB')
,('Mohammed Siraj','Bowler',70000000,'India','RCB')
,('Ambati Rayudu','WK- Batsman',67500000,'India','CSK')
,('Quinton de Kock','WK-Batsman',67500000,'South Africa','LSG')
,('Jonny Bairstow','WK-Batsman',67500000,'England','PBKS')
,('Anrich Nortje','Bowler',65000000,'South Africa','DC')
,('Mitchell Marsh','All-rounder',65000000,'Australia','DC')
,('Yuzvendra Chahal','Bowler',65000000,'India','RR')
,('Abhishek Sharma','All-rounder',65000000,'India','SRH')
,('David Warner','Batsman',62500000,'Australia','DC')
,('Mohammed Shami','Bowler',62500000,'India','GT')
,('Ruturaj Gaikwad','Batsman',60000000,'India','CSK')
,('Shivam Mavi','Bowler',60000000,'India','GT')
,('Sunil Narine','All-rounder',60000000,'West Indies','KKR')
,('Deepak Hooda','All-rounder',57500000,'India','LSG')
,('Jason Holder','All-rounder',57500000,'West Indies','RR')
,('Mukesh Kumar','Bowler',55000000,'India','DC')
,('Dinesh Karthik','WK-Batsman',55000000,'India','RCB')
,('Khaleel Ahmed','Bowler',52500000,'India','DC')
,('Rahul Chahar','Bowler',52500000,'India','PBKS')
,('Heich Klaasen','WK-Batsman',52000000,'South Africa','SRH')
,('Ravichandran Ashwin','All-rounder',50000000,'India','RR')
,('Rilee Rossouw','Batsman',46000000,'South Africa','DC')
,('Joshua Little','Bowler',44000000,'Ireland','GT')
,('Chetan Sakariya','Bowler',42000000,'India','DC')
,('Bhuvneshwar Kumar','Bowler',42000000,'India','SRH')
,('Marco Jansen','All-rounder',42000000,'South Africa','SRH')
,('Shivam Dube','All-rounder',40000000,'India','CSK')
,('Ravi Bishnoi','Bowler',40000000,'India','LSG')
,('Yashasvi Jaiswal','Batsman',40000000,'India','RR')
,('Umran Malik','Bowler',40000000,'India','SRH')
,('Kartik Tyagi','Bowler',40000000,'India','SRH')
,('T Natarajan','Bowler',40000000,'India','SRH')
,('Abdul Samad','All-rounder',40000000,'India','SRH')
,('Arshdeep Singh','Bowler',40000000,'India','PBKS')
,('Riyan Parag','All-rounder',38000000,'India','RR')
,('Harpreet Brar','Bowler',38000000,'India','PBKS')
,('Anuj Rawat','WK-Batsman',34000000,'India','RCB')
,('Yash Dayal','Bowler',32000000,'India','GT')
,('Will Jacks','Allrounder',32000000,'England','RCB')
,('David Miller','Batsman',30000000,'South Africa','GT')
,('R Sai Kishore','Bowler',30000000,'India','GT')
,('Dewald Brevis','Batsman',30000000,'India','MI')
,('Rovman Powell','Batsman',28000000,'West Indies','DC')
,('Abhinav Sadarangani','Batsman',26000000,'India','GT')
,('Navdeep Saini','Bowler',26000000,'India','RR')
,('Aiden Markram','Batsman',26000000,'South Africa','SRH')
,('Vivrant Sharma','All-rounder',26000000,'India','SRH')
,('Manish Pandey','Batsman',24000000,'India','DC')
,('Matthew Wade','WK-Batsman',24000000,'Australia','GT')
,('Alzarri Joseph','Bowler',24000000,'West Indies','GT')
,('Shahbaz Ahmed','All-rounder',24000000,'India','RCB')
,('Mustafizur Rahman','Bowler',20000000,'Bangladesh','DC')
,('Kuldeep Yadav','Bowler',20000000,'India','DC')
,('Phil Salt','WT-Batsman',20000000,'England','DC')
,('Kane Williamson','Batsman',20000000,'New Zealand','GT')
,('Umesh Yadav','Bowlers',20000000,'India','KKR')
,('David Willey','All-rounder',20000000,'England','RCB')
,('Adil Rashid','Bowler',20000000,'England','SRH')
,('Raj Bawa','Bowler',20000000,'India','PBKS')
,('Mitchell Santner','Bowler',19000000,'New Zealand','CSK')
,('Wriddhiman Saha','WK-Batsman',19000000,'India','GT')
,('Reece Topley','Bowler',19000000,'England','RCB')
,('Mayank Dagar','All-rounder',18000000,'India','SRH')
,('Jayant Yadav','All-rounder',17000000,'India','GT')
,('Tilak Varma','Batsman',17000000,'India','MI')
,('Rajvardhan Hangargekar','Bowler',15000000,'India','CSK')
,('Tim Southee','Bowlers',15000000,'New Zealand','KKR')
,('Shakib Al Hasan','All-rounder',15000000,'Bangladesh','KKR')
,('Jhye Richardson','Bowler',15000000,'Australia','MI')
,('Adam Zampa','Bowler',15000000,'Australia','RR')
,('Glenn Phillips','WK-Batsman',15000000,'New Zealand','SRH')
,('Vijay Shankar','All-rounder',14000000,'India','GT')
,('Prashant Solanki','Bowler',12000000,'India','CSK')
,('KS Bharat','WK-Batsman',12000000,'India','GT')
,('Kamlesh Nagarkoti','Bowler',11000000,'India','DC')
,('Devon Conway','Batsman',10000000,'New Zealand','CSK')
,('Kyle Jamieson','Bowler',10000000,'New Zealand','CSK')
,('David Wiese','All-rounder',10000000,'Namibia','KKR')
,('Joe Root','Batter',10000000,'England','RR')
,('Akeal Hosein','Bowler',10000000,'West Indies','SRH')
,('Mahipal Lomror','All-rounder',9500000,'India','RCB')
,('N. Jagadeesan','WK-Batsman',9000000,'India','KKR')
,('K Gowtham','All-rounder',9000000,'India','LSG')
,('Finn Allen','WK-Batsman',8000000,'New Zealand','RCB')
,('Daniel Sams','All-rounder',7500000,'Australia','LSG')
,('Obed McCoy','Bowler',7500000,'West Indies','RR')
,('Siddarth Kaul','Bowler',7500000,'India','RCB')
,('Nathan Ellis','Bowler',7500000,'Australia','PBKS')
,('Maheesh Theekshana','Bowler',7000000,'Sri Lanka','CSK')
,('Rajan Kumar','Bowler',7000000,'India','RCB')
,('Lalit Yadav','All-rounder',6500000,'India','DC')
,('Vaibhav Arora','Bowler',6000000,'India','KKR')
,('Avinash Singh','Bowler',6000000,'India','RCB')
,('Prabhsimran Singh','WK-Batsman',6000000,'India','PBKS')
,('Rinku Singh','Batsman',5500000,'India','KKR')
,('Rishi Dhawan','All-rounder',5500000,'India','PBKS')
,('Dwaine Pretorius','All-rounder',5000000,'South Africa','CSK')
,('A Rahane','Batsman',5000000,'India','CSK')
,('Yash Dhull','Batsman',5000000,'India','DC')
,('Lungi Ngidi','Bowler',5000000,'South Africa','DC')
,('Praveen Dubey','Bowler',5000000,'India','DC')
,('Ishant Sharma','Bowler',5000000,'India','DC')
,('Odean Smith','All-rounder',5000000,'West Indies','GT')
,('Mohit Sharma','Bowler',5000000,'India','GT')
,('Rahmanullah Gurbaz','WK-Batsman',5000000,'Afghanistan','KKR')
,('Litton Das','WK-Batsman',5000000,'Bangladesh','KKR')
,('Mandeep Singh','Batsman',5000000,'India','KKR')
,('Kyle Mayers','All-rounder',5000000,'West Indies','LSG')
,('Jaydev Unadkat','Bowler',5000000,'India','LSG')
,('Romario Shepherd','All-rounder',5000000,'West Indies','LSG')
,('Amit Mishra','Bowler',5000000,'India','LSG')
,('Naveen-ul-Haq','Bowler',5000000,'Afghanistan','LSG')
,('Piyush Chawla','Bowler',5000000,'India','MI')
,('Donovan Ferreira','WK-Batsman',5000000,'South Africa','RR')
,('Karn Sharma','Bowler',5000000,'India','RCB')
,('Fazal Haq Farooqi','Bowler',5000000,'Afghanistan','SRH')
,('Mayank Markande','Bowler',5000000,'India','SRH')
,('Bhanuka Rajapaksa','Batsman',5000000,'Sri Lanka','PBKS')
,('Sikandar Raza','All-rounder',5000000,'Zimbabwe','PBKS')
,('Yash Thakur','Bowler',4500000,'India','LSG')
,('Harpreet Bhatia','Batsman',4000000,'India','PBKS')
,('Noor Ahmad','Bowler',3000000,'Afghanistan','GT')
,('Arjun Tendulkar','All-rounder',3000000,'India','MI')
,('KC Kariappa','Bowler',3000000,'India','RR')
,('KM Asif','Bowler',3000000,'India','RR')
,('Suyash Prabhudessai','Batsman',3000000,'India','RCB')
,('Upendra Yadav','WK-Batsman',2500000,'India','SRH')
,('Subhranshu Senapati','Batsman',2000000,'India','CSK')
,('Tushar Deshpande','Bowler',2000000,'India','CSK')
,('Simranjeet Singh','Bowler',2000000,'India','CSK')
,('Matheesha Pathirana','Bowler',2000000,'Sri Lanka','CSK')
,('Mukesh Choudhary','Bowler',2000000,'India','CSK')
,('Nishant Sindhu','All-rounder',2000000,'India','CSK')
,('Shaik Rasheed','Batsman',2000000,'India','CSK')
,('Ajay Mandal','Bowler',2000000,'India','CSK')
,('Bhagath Verma','All-rounder',2000000,'India','CSK')
,('Sarfaraz Khan','Batsman',2000000,'India','DC')
,('Ripal Patel','All-rounder',2000000,'India','DC')
,('Vicky Ostwal','All-rounder',2000000,'India','DC')
,('Aman Khan','Allrounder',2000000,'India','DC')
,('Sai Sudarshan','Batsman',2000000,'India','GT')
,('Darshan Nalkande','Bowler',2000000,'India','GT')
,('Pradeep Sangwan','Bowler',2000000,'India','GT')
,('Urvil Patel','WK-Batsman',2000000,'India','GT')
,('Anukul Roy','All-rounder',2000000,'India','KKR')
,('Harshit Rana','Bowler',2000000,'India','KKR')
,('Suyash Sharma','Bowler',2000000,'India','KKR')
,('Kulwant Khejroliya','Bowler',2000000,'India','KKR')
,('Manan Vohra','Batsman',2000000,'India','LSG')
,('Mohsin Khan','Bowler',2000000,'India','LSG')
,('Mayank Yadav','Bowler',2000000,'India','LSG')
,('Karan Sharma','All-rounder',2000000,'India','LSG')
,('Ayush Badoni','All-rounder',2000000,'India','LSG')
,('Prerak Mankad','All-rounder',2000000,'India','LSG')
,('Swapnil Singh','All-rounder',2000000,'India','LSG')
,('Yudhvir Charak','All-rounder',2000000,'India','LSG')
,('Ramandeep Singh','Batsman',2000000,'India','MI')
,('Kumar Kartikeya Singh','Bowler',2000000,'India','MI')
,('Hrithik Shokeen','All-rounder',2000000,'India','MI')
,('Tristan Stubbs','WK-Batsman',2000000,'South Africa','MI')
,('Arshad Khan','All-rounder',2000000,'India','MI')
,('Akash Madhwal','Bowler',2000000,'India','MI')
,('Jason Behrendorff','Bowler',2000000,'Australia','MI')
,('Duan Jansen','All-rounder',2000000,'South Africa','MI')
,('Shams Mulani','All-rounder',2000000,'India','MI')
,('Nehal Wadhera','All-rounder',2000000,'India','MI')
,('Vishnu Vinod','WK-Batsman',2000000,'India','MI')
,('Raghav Goyal','Bowler',2000000,'India','MI')
,('Dhruv Jurel','WK-Batsman',2000000,'India','RR')
,('Kuldip Yadav','Bowler',2000000,'India','RR')
,('Kuldeep Sen','Bowler',2000000,'India','RR')
,('Kunal Rathore','WK-Batsman',2000000,'India','RR')
,('Murugan Ashwin','Bowler',2000000,'India','RR')
,('Akash Vashisht','All-rounder',2000000,'India','RR')
,('Abdul P A','Bowler',2000000,'India','RR')
,('Rajat Patidar','Batsman',2000000,'India','RCB')
,('Akash Deep','Bowler',2000000,'India','RCB')
,('Himanshu Sharma','Bowler',2000000,'India','RCB')
,('Manoj Bhandage','Allrounder',2000000,'India','RCB')
,('R Sonu Yadav','Allrounder',2000000,'India','RCB')
,('Samarth Vyas','All-rounder',2000000,'India','SRH')
,('Sanvir Singh','All-rounder',2000000,'India','SRH')
,('Nitish Kumar Reddy','WK-Batsman',2000000,'India','SRH')
,('Anmolpreet Singh','Batman',2000000,'India','SRH')
,('Jitesh Sharma','WK-Batsman',2000000,'India','PBKS')
,('Baltej Singh','All-rounder',2000000,'India','PBKS')
,('Atharva Taide','All-rounder',2000000,'India','PBKS')
,('Vidwath Kaverappa','Bowler',2000000,'India','PBKS')
,('Mohit Rathee','All-rounder',2000000,'India','PBKS')
,('Shivam Singh','All-rounder',2000000,'India','PBKS');


select * from player;


alter table player add constraint fk_team_player foreign key(team) references team_details(team);


select * from player;
select * from team_details;

select * from player where amount=(select min(amount) from player) order by team;

select team,amount,count(1) from player where amount = (select min(amount) from player) group by team,amount having count(1) <5 order by count desc;

-- player name, role, amount, team, team_name, captain

select p.name,p.role,p.amount,t.team,t.name,t.captain  from player p left outer join team_details t on p.team = t.team;

update player set team  = null where team='CSK';


select * from team_details td;

select t.team,t.name,p.name,p.role,p.amount from player p left outer join  team_details t on p.team=t.team;

