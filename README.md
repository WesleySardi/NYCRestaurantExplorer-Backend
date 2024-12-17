
# NYC Restaurant Explorer - Back-end

**NYC Restaurant Explorer** is a backend project designed to provide endpoints for managing restaurants and their inspections in New York City. The application allows functionalities for searching, creating, updating, and deleting restaurant information, as well as providing data related to restaurant inspections, such as the quantity and the date of the last inspection. The API also supports filtered queries to facilitate searching for restaurants based on criteria like cuisine type, inspection grade, and location.

---

## Setup Instructions

To set up the project locally, follow the steps below:

### Prerequisites:
1. **Java 17** or higher
2. **Maven** for dependency management and build
3. **IDE** (Integrated Development Environment) like IntelliJ IDEA or Eclipse

### Steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/WesleySardi/NYCRestaurantExplorer-Backend.git
   cd NYCRestaurantExplorer-Backend
   ```

2. **Build the project:**

   If you have Maven installed, you can build the project with the following command:

   ```bash
   mvn clean install
   ```

   This command will download all necessary dependencies and build the project.

3. **Run the application:**

   You can run the Spring Boot application directly using Maven:

   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run it from your IDE by executing the `NycrestaurantexplorerApplication` class, which contains the `main()` method.

4. **Configure the database:**

   The project is configured to use PostgreSQL in production. For development, you can use an in-memory H2 database.

   Configure your `application.properties` file for database connection:

   - **For H2 (development):**
     ```properties
     spring.datasource.url=jdbc:h2:mem:testdb
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=password
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
     spring.h2.console.enabled=true
     ```

   - **For PostgreSQL (production):**
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
     ```

5. **Access the Swagger UI:**

   After the application is running, you can access the API documentation via Swagger UI at the following URL:

   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## API Documentation

The application provides RESTful endpoints for restaurant management. Below is a detailed documentation of the available endpoints:

### 1. **Get Restaurants by Filters**
   - **URL:** `/api/restaurants`
   - **Method:** `GET`
   - **Description:** Retrieves restaurants based on filters such as cuisine type, inspection grade, and borough.
   - **Parameters:**
     - `grade` (optional): Cuisine type (e.g., "Italian")
     - `borough` (optional): The borough where the restaurant is located (e.g., "Brooklyn")
     - `cuisineDescription` (optional): Cuisine description
     - `page` (optional): Page number (default: 1)
     - `size` (optional): Items per page (default: 20)
     - `sortBy` (optional): Sorting field (e.g., "name", "grade", "inspection_date")
     - `sortDirection` (optional): Sorting direction (e.g., "asc", "desc")
   
   - **Responses:**
     - `200 OK`: Restaurants retrieved successfully
     - `400 Bad Request`: Invalid parameters

---

### 2. **Search Restaurants by Name**
   - **URL:** `/api/restaurants/search`
   - **Method:** `GET`
   - **Description:** Searches for restaurants by name with pagination support.
   - **Parameters:**
     - `name`: Name of the restaurant (required)
     - `page`: Page number (default: 1)
     - `size`: Items per page (default: 20)
     - `sortBy`: Sorting field (default: "name")
     - `sortDirection`: Sorting direction (default: "asc")
   
   - **Responses:**
     - `200 OK`: Restaurants found successfully
     - `400 Bad Request`: Invalid name parameter

---

### 3. **Get All Restaurants**
   - **URL:** `/api/restaurants/find-all`
   - **Method:** `GET`
   - **Description:** Retrieves all registered restaurants in the system.
   
   - **Responses:**
     - `200 OK`: Restaurants retrieved successfully
     - `500 Internal Server Error`: Error retrieving the restaurants

---

### 4. **Create a Restaurant**
   - **URL:** `/api/restaurants`
   - **Method:** `POST`
   - **Description:** Creates a new restaurant.
   - **Request Body:** 
     - `PostRestaurantCommand` object containing restaurant data (name, cuisine type, borough, grade, etc.)
   
   - **Responses:**
     - `201 Created`: Restaurant created successfully

---

### 5. **Update a Restaurant**
   - **URL:** `/api/restaurants/{id}`
   - **Method:** `PUT`
   - **Description:** Updates information for an existing restaurant.
   - **Parameters:**
     - `id`: ID of the restaurant to be updated
   - **Request Body:** 
     - `PutRestaurantCommand` object containing updated restaurant data
     
   - **Responses:**
     - `200 OK`: Restaurant updated successfully

---

### 6. **Delete a Restaurant**
   - **URL:** `/api/restaurants/{id}`
   - **Method:** `DELETE`
   - **Description:** Deletes a restaurant from the system.
   - **Parameters:**
     - `id`: ID of the restaurant to be deleted
   
   - **Responses:**
     - `204 No Content`: Restaurant deleted successfully

---

### 7. **Get a Restaurant by ID**
   - **URL:** `/api/restaurants/{id}`
   - **Method:** `GET`
   - **Description:** Retrieves a single restaurant by its ID.
   - **Parameters:**
     - `id`: ID of the restaurant to be retrieved
   
   - **Responses:**
     - `200 OK`: Restaurant retrieved successfully

---

### 8. **Delete an Inspection**
   - **URL:** `/api/inspections/{id}`
   - **Method:** `DELETE`
   - **Description:** Deletes an inspection from the system.
   - **Parameters:**
     - `id`: ID of the inspection to be deleted
   
   - **Responses:**
     - `204 No Content`: Inspection deleted successfully

---

### Swagger Documentation

To explore and test the API endpoints, you can use the Swagger UI, which provides a graphical interface to interact with the REST API.

- **Swagger URL:** `http://localhost:8080/swagger-ui.html`

---

## Conclusion

This project offers a robust backend for managing restaurant data and their inspections. It allows easy querying, manipulation, and management of restaurant records in New York City through a simple-to-use API. The application can be extended to include additional features, such as integration with other databases or new functionalities.
