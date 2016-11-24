package be.howest.ti.pokedex.data;

import be.howest.ti.pokedex.PokedexException;
import be.howest.ti.pokedex.model.Location;
import be.howest.ti.pokedex.model.Pokemon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDA {

    public final static PokemonDA instance = new PokemonDA();

    private static final String URL = "jdbc:mysql://localhost/pokemon";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    protected PokemonDA() {
        this.registerDriver();
        this.openConnection();
    }

    private void registerDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new PokedexException("Unable to load MySQL driver.", ex);
        }
    }

    private void openConnection() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            throw new PokedexException("Unable to open connection.", ex);
        }
    }

    public Pokemon loadPokemon(int id) {
        try {
            String sql = "SELECT identifier FROM pokemon.pokemon WHERE id = ?;";

            PreparedStatement prep = this.connection.prepareStatement(sql);
            prep.setInt(1, id);

            Pokemon p = null;
            ResultSet rs = prep.executeQuery();

            rs.next();
            p = new Pokemon(id, rs.getString("identifier"));

            rs.close();
            prep.close();
            return p;

        } catch (SQLException ex) {
            throw new PokedexException("Unable to retrieve pokemon.", ex);
        }
    }

    public void recordEncounter(Pokemon p, Location l) {
        try {
            String sql = "INSERT INTO encounters VALUES(?,?,?);";

            PreparedStatement prep = this.connection.prepareStatement(sql);
            prep.setInt(1, p.getId());
            prep.setInt(2, l.getX());
            prep.setInt(3, l.getY());

            prep.execute();

        } catch (SQLException ex) {
            throw new PokedexException("Unable to store pokemon encounter.", ex);
        }
    }

    public List<Location> retrieveEncounters(Pokemon p) {
        if (p == null) {
            return null;
        }
        try {
            String sql = "SELECT x,y FROM encounters WHERE pokemon = ?;";
            PreparedStatement prep = this.connection.prepareStatement(sql);
            prep.setInt(1, p.getId());

            ResultSet rs = prep.executeQuery();

            List<Location> res = new ArrayList<>();
            while (rs.next()) {
                res.add(new Location(rs.getInt("x"), rs.getInt("y")));
            }
            return res;
        } catch (SQLException ex) {
            throw new PokedexException("Unable to store pokemon encounter.", ex);
        }
    }

}
