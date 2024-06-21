package jp.co.axiz.kanri.util;

import java.util.List;

import jp.co.axiz.kanri.entity.Gender;
import jp.co.axiz.kanri.entity.Position;

/*
 * 共通メソッドクラス
 */
public class ParamUtil {

	/**
     * 引数に指定した文字列がnull、または空文字かを判定
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 全ての項目が未入力の場合
     */
    public static boolean isAllNullOrEmpty(Integer empId, String empName, String empKana, String tel) {

    	if (empId == null && (empName.isEmpty() || empName == null) && (empKana.isEmpty() || empKana == null) && (tel.isEmpty() || tel == null)) {

    		return true;
    	} else {
    		return false;
    	}
    }

    /**
     * 引数に指定した文字列が数値に変換できるかを判定
     */
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    /**
     * 引数に指定した文字列が数値に変換して返却する。
     * 変換できない場合はnullを返却する。
     */
    public static Integer checkAndParseInt(String str) {
        if (isNumber(str)) {
            return Integer.parseInt(str);
        } else {
            return null;
        }
    }


    /**
     * 第1引数に指定したposition_idに対応するposition_nameを第2引数から検索する。
     * 該当するデータがあればposition_nameを変革する。無ければEmptyを返却する。
     */
    public static String getPositionNameByPositionId(Integer targetPositionId, List<Position> positionList) {
        // 役職名取得
        for (Position position : positionList) {
            if (position.getPositionId() == targetPositionId) {
                return position.getPositionName();
            }
        }

        return "";
    }


    /**
     * 第1引数に指定したgender_idに対応するgender_nameを第2引数から検索する。
     * 該当するデータがあればgender_nameを変革する。無ければEmptyを返却する。
     */
    public static String getGenderNameByGenderId(Integer targetGenderId, List<Gender> genderList) {
        // 役職名取得
        for (Gender gender : genderList) {
            if (gender.getGenderId() == targetGenderId) {
                return gender.getGenderName();
            }
        }

        return "";
    }
}
