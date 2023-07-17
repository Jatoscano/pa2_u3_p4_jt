package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements CiudadanoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Ciudadano ciudadano) {
		
		this.entityManager.persist(ciudadano);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		
		this.entityManager.merge(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}
	//JOINS

		//INNNER JOIN
		@Override
		public List<Ciudadano> seleccionarInnerJoin() {
			
			//SQL
			//SELECT * FROM Ciudadano c INNER JOIN Empleado em ON c.ciud_id = em.empl_ciudadano_id
			
			//JPQL
			//SELECT c FROM Ciudadano c INNER JOIN c.empleado em
			
			
			TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(
					"SELECT c FROM Ciudadano c INNER JOIN c.empleado em"
					,Ciudadano.class);
			
			return myTypedQuery.getResultList();
		}

		//OUTER JOIN
		
		
		//RIGHT JOIN
		@Override
		public List<Ciudadano> seleccionarOuterRightJoin() {
			//SQL
			//SELECT * FROM Ciudadano c RIGHT JOIN Empleado em ON c.ciud_id = em.empl_ciudadano_id
			
			//JPQL
			//SELECT c FROM Ciudadano c RIGHT JOIN c.empleado em
			
			TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(
					"SELECT c FROM Ciudadano c RIGHT JOIN c.empleado em"
					,Ciudadano.class);
			
			return myTypedQuery.getResultList();
		}

		//LEFT JOIN
		@Override
		public List<Ciudadano> seleccionarOuterLeftJoin() {
			//SQL
			//SELECT * FROM Ciudadano c LEFT JOIN Empleado em ON c.ciud_id = em.empl_ciudadano_id
			
			//JPQL
			//SELECT c FROM Ciudadano c LEFT JOIN c.empleado em
			
			TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(
					"SELECT c FROM Ciudadano c LEFT JOIN c.empleado em"
					,Ciudadano.class);
			
			return myTypedQuery.getResultList();
		}

		
		//FULL OUTER JOIN
		@Override
		public List<Ciudadano> seleccionarOuterFullJoin() {
			//SQL
			//SELECT * FROM Ciudadano c FULL JOIN Empleado em ON c.ciud_id = em.empl_ciudadano_id
			
			//JPQL
			//SELECT c FROM Ciudadano c FULL JOIN c.empleado em
			
			TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(
					"SELECT c FROM Ciudadano c FULL JOIN c.empleado em"
					,Ciudadano.class);
			
			return myTypedQuery.getResultList();
		}

		//Join Where
		
		@Override
		public List<Ciudadano> seleccionarWhereJoin() {
			//SQL
			//SELECT * FROM Ciudadano c, Empleado em WHERE c.ciud_id = em.empl_ciudadano_id
									
		    //JPQL
			//SELECT c FROM Ciudadano c, Empleado em WHERE c = em.ciudadano
									
			TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(
					"SELECT c FROM Ciudadano c, Empleado em WHERE c = em.ciudadano"
					,Ciudadano.class);
									
		    return myTypedQuery.getResultList();
		}

	//Join Fetch	
		@Override
		public List<Ciudadano> seleccionarJoinFetch() {
			//SQL
			//SELECT * FROM Ciudadano c JOIN FETCH Empleado em ON c.ciud_id = em.empl_ciudadano_id
			
			//JPQL
			//SELECT c FROM Ciudadano c JOIN FETCH c.empleado em
			
			TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(
					"SELECT c FROM Ciudadano c JOIN FETCH c.empleado em"
					,Ciudadano.class);
			
			return myTypedQuery.getResultList();
		}	
	
		
}
