package com.example.PaoKentin.repository;

import com.example.PaoKentin.model.Pao;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaoRepository {


    protected PaoRepository() {

    }

    public void create(Pao p) throws SQLException {

        String sql = "insert into pao(tipo_pao,descricao,tempo_preparo) values(?,?,?)";
//
        PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

        pstm.setString(1, p.getTipoPao());
        pstm.setString(2, p.getDescricao());
        pstm.setInt(3, p.getTempoPreparo());

        pstm.execute();

    }

    public void update(Pao p) {

        String sql = "update pao set tipo_pao=?, descricao=?, tempo_preparo=? where id=?";

        try {

            PreparedStatement pstm  = ConnectioManager.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, p.getTipoPao());
            pstm.setString(2, p.getDescricao());
            pstm.setInt(3, p.getTempoPreparo());

            pstm.setInt(4, p.getId());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pao read(Integer id) {

        String sql = "select * from pao where id=?";

        try {

            PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            ResultSet result = pstm.executeQuery();

            Pao nPao = null;

            if(result.next()) {
                nPao = new Pao();
                nPao.setId(id);
                nPao.setTipoPao(result.getString("tipo_pao"));
                nPao.setDescricao(result.getString("descricao"));
                nPao.setTempoPreparo(result.getInt("tempo_preparo"));
            }

            return nPao;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(Integer id) {

        String sql = "delete from pao where id = ?";

        try {

            PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pao> readAll() {

        String sql = "select * from pao";

        List<Pao> paes = new ArrayList<>();

        try {

            PreparedStatement pstm = ConnectioManager.getCurrentConnection().prepareStatement(sql);

            ResultSet result = pstm.executeQuery();

            Pao nPao = null;

            while (result.next()) {
                nPao = new Pao();;
                nPao.setId(result.getInt("id"));
                nPao.setTipoPao(result.getString("tipo_pao"));
                nPao.setDescricao(result.getString("descricao"));
                nPao.setTempoPreparo(result.getInt("tempo_preparo"));

                paes.add(nPao);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paes;
    }

}
