# Java-sql-Project

🍿 Netflix Tracker
🧭 Objective

The Netflix Tracker is a web-based application designed to help users track, organize, and analyze their Netflix watch history, favorites, and viewing patterns.
It allows users to manage movies and TV shows they’ve watched, are currently watching, or plan to watch — all in one intuitive dashboard.

🧩 Core Features / Use Cases
🔐 1. User Authentication

Secure login and signup system.

Each user can have a personalized Netflix Tracker dashboard.

🎥 2. Watchlist Management

Add, update, and delete movies or series from your personal watchlist.

Categorize shows as:

Watching

Completed

Plan to Watch

Dropped

⭐ 3. Ratings & Reviews

Users can rate watched content and write reviews.

Display user’s top-rated titles and most-watched genres.

🧠 4. Content Insights

Automatically calculates viewing statistics such as:

Total number of shows watched.

Average rating.

Genre distribution charts.

Filter content by genre, release year, or status.

🔍 5. Search & Filter

Search movies or series by name.

Apply multiple filters (e.g., Genre + Rating + Watch Status).

📊 6. Recommendation Module (Optional Enhancement)

Suggests new titles based on user preferences and watch history.

🧱 System Modules
Module	Description
User Module	Handles registration, authentication, and user profiles.
Watchlist Module	Stores and manages movies/series data for each user.
Rating & Review Module	Records user ratings and feedback.
Analytics Module	Provides watch statistics and insights.
Recommendation Module	Suggests new shows based on user’s interest.
⚙️ Expected Design Components
🧩 UML Diagrams

Use Case Diagram – User interactions for adding, rating, and tracking shows.

Activity Diagram – Flow of adding and updating watchlist entries.

🧬 ER Diagram

Entities:

User

Movie/Series

Watchlist

Ratings

Genre

Relationships:

A user can have many watchlist items.

A movie can belong to multiple genres.

A rating is linked to one user and one movie.

🧰 Technology Stack
Layer	Technology
Frontend	HTML, CSS, JavaScript, React (optional)
Backend	Java (Spring Boot) / Python (Flask / Django)
Database	MySQL / MongoDB
Security	Spring Security / JWT Authentication
Version Control	Git & GitHub
Build Tool	Maven / npm
IDE	VS Code / IntelliJ IDEA / PyCharm
🗄️ Database Design
👤 users
Field	Type	Description
user_id	BIGINT	Primary Key
username	VARCHAR(100)	Unique username
password	VARCHAR(255)	Encrypted password
email	VARCHAR(255)	User email
🎬 movies
Field	Type	Description
movie_id	BIGINT	Primary Key
title	VARCHAR(255)	Movie or series title
genre	VARCHAR(100)	Genre (Action, Drama, etc.)
release_year	INT	Year of release
duration	VARCHAR(50)	Runtime (in minutes or seasons)
🧾 watchlist
Field	Type	Description
id	BIGINT	Primary Key
user_id	BIGINT	Foreign Key (users)
movie_id	BIGINT	Foreign Key (movies)
status	VARCHAR(50)	(Watching / Completed / Plan to Watch / Dropped)
date_added	DATE	When it was added
⭐ ratings
Field	Type	Description
id	BIGINT	Primary Key
user_id	BIGINT	Foreign Key (users)
movie_id	BIGINT	Foreign Key (movies)
rating	FLOAT	User rating (1–10)
review	TEXT	Optional review text
🔗 RESTful API Endpoints
Endpoint	Method	Description
/users/register	POST	Register new user
/users/login	POST	Login
/movies	GET	Fetch all movies
/movies/add	POST	Add new movie
/watchlist	GET	Get user’s watchlist
/watchlist/add	POST	Add to watchlist
/watchlist/delete/{id}	DELETE	Remove from watchlist
/ratings/add	POST	Add or update rating
/analytics	GET	View user statistics
🧮 Role-Based Access
Role	Permissions
User	Manage personal watchlist, ratings, and reviews
Admin	Manage all users and database entries
Guest	View movie database (limited access)


Access in Browser

http://localhost:8080

📈 Future Enhancements

🎯 AI-based personalized recommendations

📱 Mobile-friendly responsive UI

📊 Integration with external APIs (like TMDb for movie details)

🔔 Notification for new releases

📤 Export watchlist or stats to Excel / PDF
