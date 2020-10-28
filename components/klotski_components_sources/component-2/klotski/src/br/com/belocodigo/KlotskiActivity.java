/*
 * Copyright 2010-2010 André Ribeiro de Miranda
 * 
 * Klotski is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Klotski is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Less General Public License for more details.
 * 
 * You should have received a copy of the GNU Less General Public License
 * along with Klotski.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package br.com.belocodigo;

import br.com.belocodigo.view.KlotskiView;
import android.app.Activity;
import android.os.Bundle;

public class KlotskiActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		QuebraCabecas quebraCabecas = QuebraCabecas.getInstance();
		quebraCabecas.carregarQuebraCebeca(0);

		KlotskiView klotskiView = new KlotskiView(this, quebraCabecas
				.getQuebraCabeca());

		setContentView(klotskiView);
	}
}