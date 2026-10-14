package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    // Öğrenci tablosundaki tüm kayıtları listeleyin.
    String QUESTION_1 = "SELECT * FROM ogrenci";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();

    // Öğrenci tablosundaki kız öğrencileri listeleyin.
    String QUESTION_2 = "SELECT * FROM ogrenci WHERE cinsiyet = 'K'";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();

    // Sınıfları tekrarsız listeleyin.
    String QUESTION_3 = "SELECT DISTINCT sinif FROM ogrenci";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();

    // 10A sınıfındaki kız öğrenciler.
    String QUESTION_4 = "SELECT * FROM ogrenci WHERE sinif = '10A' AND cinsiyet = 'K'";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();

    // Öğrenci numarası 5 ile 10 arasında olan kız öğrenciler.
    String QUESTION_5 = "SELECT * FROM ogrenci WHERE ogrno BETWEEN 5 AND 10 AND cinsiyet = 'K'";
    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    // Öğrencileri adına göre alfabetik sıralayın.
    String QUESTION_6 = "SELECT * FROM ogrenci ORDER BY ad ASC";
    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    // 10A sınıfındaki öğrencileri okul numarasına göre azalan sıralayın.
    String QUESTION_7 = "SELECT * FROM ogrenci WHERE sinif = '10A' ORDER BY ogrno DESC";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    // En genç öğrenci.
    String QUESTION_8 = "SELECT * FROM ogrenci ORDER BY TO_DATE(dtarih, 'YYYY-MM-DD HH24:MI:SS') DESC LIMIT 1";
    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();

    // En yaşlı öğrenci.
    String QUESTION_9 = "SELECT * FROM ogrenci ORDER BY TO_DATE(dtarih, 'YYYY-MM-DD HH24:MI:SS') ASC LIMIT 1";
    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();

    // İkinci harfi E olan öğrenciler.
    String QUESTION_10 = "SELECT * FROM ogrenci WHERE ad ILIKE '_e%'";
    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();

}