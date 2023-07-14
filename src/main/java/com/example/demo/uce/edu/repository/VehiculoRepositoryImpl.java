package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Ciudadano;
import com.example.demo.uce.edu.repository.model.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements VehiculoRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		
		this.entityManager.merge(vehiculo);
	}

	@Override
	public Vehiculo seleccionar(Integer id) {
		
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}
	//JOINS

		//INNNER JOIN
		@Override
		public List<Vehiculo> seleccionarInnerJoin() {
			
			//SQL
			//SELECT * FROM Vehiculo v INNER JOIN Matriculas ma ON v.vehi_id = ma.matr_id_vehiculo
			
			//JPQL
			//SELECT v FROM Vehiculo v INNER JOIN v.matricula ma
			
			
			TypedQuery<Vehiculo> myTypedQuery = this.entityManager.createQuery(
					"SELECT v FROM Vehiculo v INNER JOIN v.matricula ma"
					,Vehiculo.class);
			
			return myTypedQuery.getResultList();
		}

	//OUTER JOIN
		
		
		//RIGHT JOIN
		@Override
		public List<Vehiculo> seleccionarOuterRightJoin() {
			//SQL
			//SELECT * FROM Vehiculo v RIGHT JOIN Matriculas ma ON v.vehi_id = ma.matr_id_vehiculo
			
			//JPQL
			//SELECT v FROM Vehiculo v RIGHT JOIN v.matricula ma

			
			TypedQuery<Vehiculo> myTypedQuery = this.entityManager.createQuery(
					"SELECT v FROM Vehiculo v RIGHT JOIN v.matricula ma"
					,Vehiculo.class);
			
			return myTypedQuery.getResultList();
		}

		//LEFT JOIN
		@Override
		public List<Vehiculo> seleccionarOuterLeftJoin() {
			///SQL
			//SELECT * FROM Vehiculo v LEFT JOIN Matriculas ma ON v.vehi_id = ma.matr_id_vehiculo
			
			//JPQL
			//SELECT v FROM Vehiculo v LEFT JOIN v.matricula ma
			
			TypedQuery<Vehiculo> myTypedQuery = this.entityManager.createQuery(
					"SELECT v FROM Vehiculo v LEFT JOIN v.matricula ma"
					,Vehiculo.class);
			
			return myTypedQuery.getResultList();
		}

		
		//FULL OUTER JOIN
		@Override
		public List<Vehiculo> seleccionarOuterFullJoin() {
			//SQL
			//SELECT * FROM Vehiculo v FULL JOIN Matriculas ma ON v.vehi_id = ma.matr_id_vehiculo
			
			//JPQL
			//SELECT v FROM Vehiculo v FULL JOIN v.matricula ma
			
			TypedQuery<Vehiculo> myTypedQuery = this.entityManager.createQuery(
					"SELECT v FROM Vehiculo v FULL JOIN v.matricula ma"
					,Vehiculo.class);
			
			return myTypedQuery.getResultList();
		}

	//Join Where
		
		@Override
		public List<Vehiculo> seleccionarWhereJoin() {
			//SQL
			//SELECT * FROM Vehiculo v, Matriculas ma WHERE v.vehi_id = ma.matr_id_vehiculo
									
		    //JPQL
			//SELECT v FROM Vehiculo v, Matriculas ma WHERE v = ma.vehiculo
									
			TypedQuery<Vehiculo> myTypedQuery = this.entityManager.createQuery(
					"SELECT v FROM Vehiculo v, Matriculas ma WHERE v = ma.vehiculo"
					,Vehiculo.class);
									
		    return myTypedQuery.getResultList();
		}

}
