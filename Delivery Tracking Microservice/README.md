# Delivery Tracking Microservice

A Spring Boot microservice for tracking delivery statuses and managing driver assignments.

## Features

- Create and manage delivery records
- Track delivery status updates
- Assign drivers to deliveries
- Query deliveries by various criteria (driver, order, status)
- RESTful API endpoints for all operations
- PostgreSQL database for persistent storage
- Docker containerization for easy deployment

## Prerequisites

- Java 17 or higher
- Maven
- Docker and Docker Compose

## Getting Started

1. Clone the repository:

```bash
git clone <repository-url>
cd delivery-tracking-service
```

2. Build and run using Docker Compose:

```bash
docker-compose up --build
```

The application will be available at `http://localhost:8081`

## API Endpoints

### Delivery Management

- `POST /api/deliveries` - Create a new delivery
- `PUT /api/deliveries/{id}` - Update a delivery
- `PATCH /api/deliveries/{id}/status` - Update delivery status
- `GET /api/deliveries/{id}` - Get delivery by ID
- `GET /api/deliveries/driver/{driverId}` - Get deliveries by driver
- `GET /api/deliveries/order/{orderId}` - Get deliveries by order
- `GET /api/deliveries/status/{status}` - Get deliveries by status
- `DELETE /api/deliveries/{id}` - Delete a delivery

## Development

To run the application locally without Docker:

1. Start PostgreSQL database
2. Update `application.properties` with your database credentials
3. Run the application:

```bash
mvn spring-boot:run
```

## Testing

Run the tests using Maven:

```bash
mvn test
```

## License

This project is licensed under the MIT License.
