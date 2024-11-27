import React from 'react'
import axios from "axios";


export const Rotas = axios.create({
            baseURL:"http://localhost:8080/usuario"
}) 
  