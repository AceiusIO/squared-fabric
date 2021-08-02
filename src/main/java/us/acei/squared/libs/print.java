/*
 * Copyright (c) 2021 AceiusIO and contributors.
 *
 * This source code is subject to the terms of the GNU Lesser General Public
 * License, version 3. If a copy of the LGPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/lgpl-3.0.txt
 */

package us.acei.squared;

public class print {
	static void sqprint(String Message) {
		System.out.println("[SQ] " + Message);
	}

	static void sqdebug(String Message) {
		sqprint("[DEBUG] " + Message);
	}
}