package com.example.PaoKentin.repository;

import com.example.PaoKentin.model.Fornada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FornadaRepository {

    @Autowired
    private PaoRepository paoRepo;

    protected FornadaRepository(){

    }

    public void create(Fornada f) throws SQLException {

        String sql = "insert into fornada(pao_id, inicio_fornada, final_fornada, tempo_restante) values(?,?,?,?)";

        PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

        pstm.setInt(1, f.getPao().getId());
        pstm.setTime(2, Time.valueOf(f.getInicioFornada()));
        pstm.setTime(3, Time.valueOf(f.getFinalFornada()));
        pstm.setInt(4, f.getTempoRestante());

        pstm.execute();

    }

    public void update(Fornada f) {

        String sql = "update fornada set pao_id=?, inicio_fornada=?, final_fornada=?, tempo_preparo=? where id=?";

        try {

            PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, f.getPao().getId());
            pstm.setTime(2, Time.valueOf(f.getInicioFornada()));
            pstm.setTime(3, Time.valueOf(f.getFinalFornada()));
            pstm.setInt(4, f.getTempoRestante());

            pstm.setInt(5, f.getId());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Fornada read(Integer id) {

        String sql = "select * from fornada where id=?";

        try{

            PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            ResultSet result = pstm.executeQuery();

            Fornada nFornada = null;

            if(result.next()) {
                nFornada = new Fornada();
                nFornada.setId(id);
                nFornada.setInicioFornada(LocalTime.parse(result.getString("inicio_fornada")));
                nFornada.setFinalFornada(LocalTime.parse(result.getString("final_fornada")));
                nFornada.setTempoRestante(result.getInt("tempo_restante"));
            }

            return nFornada;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(Integer id) {

        String sql = "delete from fornada where id=?";

        try{

            PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Fornada> readAll() {

        String sql = "select * from fornada";

        List<Fornada> fornadas = new ArrayList<>();

        try {

            PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

            ResultSet result = pstm.executeQuery();

            Fornada nFornada = null;

            while (result.next()) {
                nFornada = new Fornada();
                nFornada.setId(result.getInt("id"));
                nFornada.setPao(paoRepo.read(result.getInt("pao_id")));
                nFornada.setInicioFornada(LocalTime.parse(result.getString("inicio_fornada")));
                nFornada.setFinalFornada(LocalTime.parse(result.getString("final_fornada")));
                nFornada.setTempoRestante(result.getInt("tempo_restante"));

                fornadas.add(nFornada);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fornadas;
    }


}
