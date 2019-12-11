import React from 'react'
import {NavLink} from 'react-router-dom'

export const Navbar = () => (
    <nav className="navbar navbar-dark navbar-expand-lg bg-primary">
        <div className="navbar-brand">
            В музыкалке
        </div>

        <ul className="navbar-nav" >
            <li className="nav-item">
                <NavLink
                    className="nav-link"
                    to="/"
                    exact
                >
                    Главная
                </NavLink>
            </li>
            <li className="nav-item">
                <NavLink
                    className="nav-link"
                    to="/schoolkids"
                >
                    Ученики
                </NavLink>
            </li>

            <li className="nav-item">
                <NavLink
                    className="nav-link"
                    to="/teachers"
                >
                    Преподаватели
                </NavLink>
            </li>

            <li className="nav-item">
                <NavLink
                    className="nav-link"
                    to="/subjects"
                >
                    Дисциплины
                </NavLink>
            </li>

            <li className="nav-item">
                <NavLink
                    className="nav-link"
                    to="/marks"
                >
                    Оценки
                </NavLink>
            </li>

            <li className="nav-item">
                <NavLink
                    className="nav-link"
                    to="/homeworks"
                >
                    Домашние задания
                </NavLink>
            </li>

        </ul>
    </nav>
)