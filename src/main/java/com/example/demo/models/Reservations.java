package com.example.demo.models;

import jakarta.persistence.*;

    @Entity
    public class Reservations {

        @Id
        @SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence6", initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_seq")

        private Long reservation_id;

        private String user_id, client_id, ticket_id, tour_id, reservation_date, status;

        public Reservations() {
        }

        public Reservations(String user_id, String client_id, String ticket_id, String tour_id, String reservation_date, String status) {
            this.user_id = user_id;
            this.client_id = client_id;
            this.ticket_id = ticket_id;
            this.tour_id = tour_id;
            this.reservation_date = reservation_date;
            this.status = status;
        }

        public Long getReservation_id() {
            return reservation_id;
        }

        public void setReservation_id(Long reservation_id) {
            this.reservation_id = reservation_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }

        public String getTicket_id() {
            return ticket_id;
        }

        public void setTicket_id(String ticket_id) {
            this.ticket_id = ticket_id;
        }

        public String getTour_id() {
            return tour_id;
        }

        public void setTour_id(String tour_id) {
            this.tour_id = tour_id;
        }

        public String getReservation_date() {
            return reservation_date;
        }

        public void setReservation_date(String reservation_date) {
            this.reservation_date = reservation_date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

